package com.dict.emp.controller;

import com.alibaba.fastjson.JSONObject;
import com.dict.emp.common.ReturnUtil;
import org.springframework.stereotype.Controller;

@Controller
public class FileController {

    public JSONObject upload(){

        return ReturnUtil.returnSuccess("success");
    }




}
