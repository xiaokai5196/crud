package com.dict.emp.service.impl;

import com.dict.emp.entity.Dept;
import com.dict.emp.entity.vo.DeptInfo;
import com.dict.emp.mapper.DeptMapper;
import com.dict.emp.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;


    @Override
    public List<Dept> selectDeptList() {
        return deptMapper.selectDeptList();
    }

    @Override
    public Dept selectById(Integer deptno) {
        return deptMapper.selectById(deptno);
    }

    @Override
    public int insert(Dept dept) {
        return deptMapper.insert(dept);
    }

    @Override
    public int update(Dept dept) {
        return deptMapper.update(dept);
    }

    @Override
    public int deleteById(Integer deptno) {
        return deptMapper.deleteById(deptno);
    }

    @Override
    public List<DeptInfo> selectDeptInfo(Integer deptno) {
        return deptMapper.selectDeptInfo(deptno);
    }
}
