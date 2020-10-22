package com.dict.emp.service;

import com.dict.emp.entity.Dept;
import com.dict.emp.entity.vo.DeptInfo;

import java.util.List;

public interface DeptService {

    List<Dept> selectDeptList();

    Dept selectById(Integer deptno);

    int insert(Dept dept);

    int update(Dept dept);

    int deleteById(Integer deptno);

    List<DeptInfo> selectDeptInfo(Integer deptno);
}
