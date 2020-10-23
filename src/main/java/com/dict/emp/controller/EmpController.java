package com.dict.emp.controller;

import com.alibaba.fastjson.JSONObject;
import com.dict.emp.common.ReturnUtil;
import com.dict.emp.entity.Emp;
import com.dict.emp.entity.vo.EmpDetail;
import com.dict.emp.entity.vo.EmpInfo;
import com.dict.emp.service.EmpService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public class EmpController {

    private Logger logger = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private EmpService empService;

    /**
     * 条件+分页查询员工信息
     * 员工信息包含基本信息，部门信息和薪资等级
     * 查询条件有：根据员工姓名模糊查询，根据部门查询，根据入职起止日期查询
     * @param params 参数对象
     * @return
     */
    @PostMapping("/selectEmpList")
    public JSONObject selectEmpList(@RequestBody JSONObject params){
        PageInfo<EmpInfo> empPageInfo = empService.selectEmpList(params);
        return ReturnUtil.returnSuccess("success", empPageInfo);
    }

    /**
     * 查询部门信息，部门员工数量及部门平均薪资
     * @param params deptno
     * @return
     */
    @GetMapping("/selectDeptCount")
    public JSONObject selectDeptCount(@RequestBody JSONObject params){
        Integer deptno = params.getInteger("deptno");
        List<Map<String, Object>> maps = empService.selectDeptCount(deptno);
        return ReturnUtil.returnSuccess("success", maps);
    }

    /**
     * 动态插入员工，如果员工已存在则更新，不存在则插入
     * 数据表必须有一个唯一索引才可，这里是主键empno
     * @param emp
     * @return
     */
    @PostMapping("/insertOrUpdate")
    public JSONObject insertOrUpdate(@RequestBody Emp emp){
        try {
            empService.insertOrUpdate(emp);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.returnError("fail");
        }
        return ReturnUtil.returnSuccess("success");
    }


    /**
     * 条件插入
     * 根据员工的job插入不同的comm值
     * 当job=SALESMAN时，comm=1000，其它为null
     * @param emp
     * @return
     */
    @PostMapping("/insertByJob")
    public JSONObject insertByJob(@RequestBody Emp emp){
        try {
            empService.insertByJob(emp);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.returnError("fail");
        }
        return ReturnUtil.returnSuccess("success");
    }

    /**
     * 根据员工编号或姓名查询员工详细信息，包含基本信息，部门信息，薪资等级信息
     * @param emp empno ename
     * @return
     */
    @GetMapping("/selectDetailByIdName")
    public JSONObject selectDetailById(@RequestBody Emp emp){
        Integer empno = emp.getEmpno();
        String ename = emp.getEname();
        if (empno == null && ename == null){
            return ReturnUtil.returnError("参数为空");
        }
        EmpDetail empDetail = empService.selectDetailByIdName(emp);
        return ReturnUtil.returnSuccess("success", empDetail);
    }

}
