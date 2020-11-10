package com.dict.emp.controller;

import com.alibaba.fastjson.JSONObject;
import com.dict.emp.common.FileUtil;
import com.dict.emp.common.ReturnUtil;
import com.dict.emp.common.UUIDUtil;
import com.dict.emp.entity.FileInfo;
import com.dict.emp.service.FileService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @Value("${file.uploadPath}")
    private String uploadPath;


    /**
     * 上传文件，使用绝对路径
     * @param file 上传的文件
     * @param userId 用户id
     * @return
     */
    @PostMapping("/upload")
    @ResponseBody
    public JSONObject upload(@RequestParam("file") MultipartFile file, @RequestParam Long userId){
        if (file.isEmpty()) {
            return ReturnUtil.returnError("上传文件为空");
        }
        //获取文件各项信息
        String oldFileName = file.getOriginalFilename();
        String contentType = file.getContentType();
        String suffixName = oldFileName.substring(oldFileName.lastIndexOf("."));
        long fileSize = file.getSize();
        String fileFormatSize = FileUtil.formatFileSize(fileSize);
        String newFileName = UUID.randomUUID().toString().replace("-", "") + suffixName;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String absolutePath = uploadPath + dateFormat.format(new Date()) + "/" + newFileName;
        //封装文件信息
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileId(UUIDUtil.generatorUUID());
        fileInfo.setOldFilename(oldFileName);
        fileInfo.setNewFilename(newFileName);
        fileInfo.setFileSuffixName(suffixName);
        fileInfo.setFileContentType(contentType);
        fileInfo.setFileSize(fileSize);
        fileInfo.setFileFormatSize(fileFormatSize);
        fileInfo.setFileAbsolutePath(absolutePath);
        fileInfo.setUploadTime(new Date());
        fileInfo.setUploadUser(userId);
        //创建文件上传目录
        File dest = new File(absolutePath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            fileService.insert(fileInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.returnError("upload fail");
        }
        return ReturnUtil.returnSuccess("success", fileInfo);
    }


        /*
        * String scheme = request.getScheme();//http
            String serverName = request.getServerName();//localhsot
            int serverPort = request.getServerPort();//8080
            String contextPath = request.getContextPath();// /crud
            String servletPath = request.getServletPath();// /file/upload
        *
        * */

    /**
     * 批量上传
     * @param files
     * @return
     */
    @PostMapping("/batchUpload")
    @ResponseBody
    public JSONObject batchUpload(List<MultipartFile> files) {

        return ReturnUtil.returnSuccess("success");
    }

    @GetMapping("/selectByUserId")
    @ResponseBody
    public JSONObject selectByUserId(Long userId){
        List<FileInfo> fileInfos = fileService.selectByUserId(userId);
        return ReturnUtil.returnSuccess("success", fileInfos);

    }

    @GetMapping("/selectByFileId")
    @ResponseBody
    public JSONObject selectByFileId(@RequestParam String fileId){
        FileInfo fileInfo = fileService.selectByFileId(fileId);
        return ReturnUtil.returnSuccess("success", fileInfo);
    }


    /**
     * 文件下载/在线打开
     * @param fileId 文件id
     * @param isOnline 是否在线打开
     * @param response
     * @return
     * @throws FileNotFoundException
     */
    @GetMapping("/downLoad")
    public void downLoad(@RequestParam String fileId, boolean isOnline, HttpServletResponse response) throws IOException{
        FileInfo fileInfo = fileService.selectByFileId(fileId);
        //使用绝对路径
        FileInputStream is = new FileInputStream(new File(fileInfo.getFileAbsolutePath()));
        ServletOutputStream os = response.getOutputStream();
        //response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileInfo.getOldFilename(),"UTF-8"));
        //在线打开，浏览器能打开的才打开，打不开的下载
        response.setHeader("Content-Disposition", "inline;filename=" + URLEncoder.encode(fileInfo.getOldFilename(),"UTF-8"));
        IOUtils.copy(is, os);
        IOUtils.closeQuietly(is);
        IOUtils.closeQuietly(os);
    }

    /**
     * 删除文件及数据库信息
     * @param fileId 文件id
     * @return
     */
    @DeleteMapping("/delete")
    @ResponseBody
    public JSONObject delete(@RequestParam String fileId){
        FileInfo fileInfo = fileService.selectByFileId(fileId);
        //删除文件
        File file = new File(fileInfo.getFileAbsolutePath());
        if (file.exists()){
            file.delete();
        }
        //删除数据库信息
        fileService.delete(fileId);
        return ReturnUtil.returnSuccess("success");
    }

    @PostMapping("/ftpUpload")
    public JSONObject ftpUpload(@RequestParam MultipartFile file, @RequestParam Long userId){




        return ReturnUtil.returnSuccess("上传ftp服务器成功");
    }







}
