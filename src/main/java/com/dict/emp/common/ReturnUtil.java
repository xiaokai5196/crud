package com.dict.emp.common;

import com.alibaba.fastjson.JSONObject;
import java.util.LinkedHashMap;

public class ReturnUtil {

    private static final String RETURN_CODE_NAME = "code";
    private static final String RETURN_MESSAGE_NAME = "message";
    private static final String RETURN_DATA_NAME = "data";

    private static final Integer SUCCESS_CODE = 0;
    private static final Integer ERROR_CODE = -1;

    public static JSONObject resultWithNoData(int code, String message, Object data){
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put(RETURN_CODE_NAME, code);
        jsonObject.put(RETURN_MESSAGE_NAME, message);
        jsonObject.put(RETURN_DATA_NAME, null);
        return jsonObject;
    }

    public static JSONObject resultWithData(int code, String message, Object data){
        JSONObject jsonObject = new JSONObject(new LinkedHashMap<>());
        jsonObject.put(RETURN_CODE_NAME, code);
        jsonObject.put(RETURN_MESSAGE_NAME, message);
        jsonObject.put(RETURN_DATA_NAME, data);
        return jsonObject;
    }

    /**
     * 返回成功，不带数据
     * @param message 成功提示信息
     * @return
     */
    public static JSONObject returnSuccess(String message){
        return resultWithNoData(SUCCESS_CODE, message, null);
    }

    /**
     * 返回失败，不带数据
     * @param message 失败提示信息
     * @return
     */
    public static JSONObject returnError(String message){
        return resultWithNoData(ERROR_CODE, message, null);
    }

    /**
     * 返回成功，带数据
     * @param message 提示信息
     * @param data 返回数据
     * @return
     */
    public static JSONObject returnSuccess(String message, Object data){
        return resultWithData(SUCCESS_CODE, message, data);
    }






}
