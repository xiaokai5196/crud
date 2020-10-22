package com.dict.emp.mapper;

import com.dict.emp.entity.Dept;
import com.dict.emp.entity.vo.DeptInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeptMapperTest {

    @Autowired
    private DeptMapper deptMapper;

    @Test
    void selectDeptList() {
        List<Dept> depts = deptMapper.selectDeptList();
        System.out.println(depts);
    }

    @Test
    void selectById() {
        Dept dept = deptMapper.selectById(20);
        System.out.println(dept);
    }

    @Test
    void insert() {
        Dept dept = new Dept();
        dept.setDeptno(50);
        dept.setDname("DEVELOP");
        dept.setLoc("changsha");
        deptMapper.insert(dept);
    }

    @Test
    void update() {
        Dept dept = new Dept();
        dept.setDeptno(50);
        dept.setDname("DEVELOP");
        dept.setLoc("CHAGNSHA");
        deptMapper.update(dept);
    }

    @Test
    void deleteById() {
        deptMapper.deleteById(50);
    }

    @Test
    void selectDeptInfo(){
        List<DeptInfo> deptInfos = deptMapper.selectDeptInfo(10);
        System.out.println(deptInfos);
    }
}