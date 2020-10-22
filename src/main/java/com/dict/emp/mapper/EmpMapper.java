package com.dict.emp.mapper;

import com.alibaba.fastjson.JSONObject;
import com.dict.emp.entity.Emp;
import com.dict.emp.entity.vo.EmpDetail;
import com.dict.emp.entity.vo.EmpInfo;

import java.util.List;
import java.util.Map;

public interface EmpMapper {

    //根据条件查询员工信息
    List<EmpInfo> selectEmpList(JSONObject params);

    List<Map<String, Object>> selectDeptCount(Integer deptno);

    int insertOrUpdate(Emp emp);

    int insertByJob(Emp emp);

    EmpDetail selectDetailByIdName(Emp emp);

}
