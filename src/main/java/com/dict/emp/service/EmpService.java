package com.dict.emp.service;

import com.alibaba.fastjson.JSONObject;
import com.dict.emp.entity.Emp;
import com.dict.emp.entity.vo.EmpDetail;
import com.dict.emp.entity.vo.EmpInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface EmpService {

    PageInfo<EmpInfo> selectEmpList(JSONObject params);

    List<Map<String, Object>> selectDeptCount(Integer deptno);

    int insertOrUpdate(Emp emp);

    int insertByJob(Emp emp);

    EmpDetail selectDetailByIdName(Emp emp);
}
