package com.dict.emp.service.impl;

import com.dict.emp.entity.FileInfo;
import com.dict.emp.mapper.FileMapper;
import com.dict.emp.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public List<FileInfo> selectByUserId(Long userId) {
        return fileMapper.selectByUserId(userId);
    }

    @Override
    public FileInfo selectByFileId(String fileId) {
        return fileMapper.selectByFileId(fileId);
    }

    @Override
    public int insert(FileInfo fileInfo) {
        return fileMapper.insert(fileInfo);
    }

    @Override
    public int update(FileInfo fileInfo) {
        return fileMapper.update(fileInfo);
    }

    @Override
    public int delete(String fileId) {
        return fileMapper.delete(fileId);
    }


}
