package com.dict.emp.service;

import com.dict.emp.entity.FileInfo;

import java.util.List;

public interface FileService {

    List<FileInfo> selectByUserId(Long userId);

    FileInfo selectByFileId(String fileId);

    int insert(FileInfo fileInfo);

    int update(FileInfo fileInfo);

    int delete(String fileId);


}
