package com.dict.emp.mapper;

import com.dict.emp.entity.FileInfo;

import java.util.List;

public interface FileMapper {

    List<FileInfo> selectByUserId(Long userId);

    FileInfo selectByFileId(String fileId);

    int insert(FileInfo fileInfo);

    int update(FileInfo fileInfo);

    int delete(String fileId);
}
