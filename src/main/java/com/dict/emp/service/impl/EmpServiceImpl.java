package com.dict.emp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dict.emp.entity.Emp;
import com.dict.emp.entity.vo.EmpDetail;
import com.dict.emp.entity.vo.EmpInfo;
import com.dict.emp.mapper.EmpMapper;
import com.dict.emp.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageInfo<EmpInfo> selectEmpList(JSONObject params) {
        Integer pageNum = params.getInteger("pageNum");
        Integer pageSize = params.getInteger("pageSize");
        if (pageNum == null || pageSize == null){
            pageNum = 1;
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<EmpInfo> empInfos = empMapper.selectEmpList(params);
        PageInfo<EmpInfo> empInfoPageInfo = new PageInfo<>(empInfos);
        return empInfoPageInfo;
    }

    @Override
    public List<Map<String, Object>> selectDeptCount(Integer deptno) {
        return empMapper.selectDeptCount(deptno);
    }

    @Override
    public int insertOrUpdate(Emp emp) {
        return empMapper.insertOrUpdate(emp);
    }

    @Override
    public int insertByJob(Emp emp) {
        return empMapper.insertByJob(emp);
    }

    @Override
    public EmpDetail selectDetailByIdName(Emp emp) {
        return empMapper.selectDetailByIdName(emp);
    }
}
