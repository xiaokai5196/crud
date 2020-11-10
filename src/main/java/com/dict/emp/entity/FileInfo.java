package com.dict.emp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class FileInfo implements Serializable {
    private static final long serialVersionUID = -6320949423067189181L;

    //文件id
    private String fileId;

    //原文件名
    private String oldFilename;

    //新文件名
    private String newFilename;

    // 文件后缀
    private String fileSuffixName;

    // 文件类型
    private String fileContentType;

    // 文件大小，默认B
    private long fileSize;

    // 文件转换后大小
    private String fileFormatSize;

    //文件相对路径
    private String fileRelativePath;

    //文件绝对路径
    private String fileAbsolutePath;

    //下载次数
    private Integer downloadCount;

    //上传时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh_CN", timezone = "GMT+8")
    private Date uploadTime;

    //上传用户id
    private Long uploadUser;
    //用户名
    private String uploadUserName;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getOldFilename() {
        return oldFilename;
    }

    public void setOldFilename(String oldFilename) {
        this.oldFilename = oldFilename;
    }

    public String getNewFilename() {
        return newFilename;
    }

    public void setNewFilename(String newFilename) {
        this.newFilename = newFilename;
    }

    public String getFileSuffixName() {
        return fileSuffixName;
    }

    public void setFileSuffixName(String fileSuffixName) {
        this.fileSuffixName = fileSuffixName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileFormatSize() {
        return fileFormatSize;
    }

    public void setFileFormatSize(String fileFormatSize) {
        this.fileFormatSize = fileFormatSize;
    }

    public String getFileRelativePath() {
        return fileRelativePath;
    }

    public void setFileRelativePath(String fileRelativePath) {
        this.fileRelativePath = fileRelativePath;
    }

    public String getFileAbsolutePath() {
        return fileAbsolutePath;
    }

    public void setFileAbsolutePath(String fileAbsolutePath) {
        this.fileAbsolutePath = fileAbsolutePath;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Long getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(Long uploadUser) {
        this.uploadUser = uploadUser;
    }

    public String getUploadUserName() {
        return uploadUserName;
    }

    public void setUploadUserName(String uploadUserName) {
        this.uploadUserName = uploadUserName;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "fileId='" + fileId + '\'' +
                ", oldFilename='" + oldFilename + '\'' +
                ", newFilename='" + newFilename + '\'' +
                ", fileSuffixName='" + fileSuffixName + '\'' +
                ", fileContentType='" + fileContentType + '\'' +
                ", fileSize=" + fileSize +
                ", fileFormatSize='" + fileFormatSize + '\'' +
                ", fileRelativePath='" + fileRelativePath + '\'' +
                ", fileAbsolutePath='" + fileAbsolutePath + '\'' +
                ", downloadCount=" + downloadCount +
                ", uploadTime=" + uploadTime +
                ", uploadUser=" + uploadUser +
                ", uploadUserName=" + uploadUserName +
                '}';
    }
}
