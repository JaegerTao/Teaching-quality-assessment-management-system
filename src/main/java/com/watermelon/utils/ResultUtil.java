package com.watermelon.utils;

import com.alibaba.fastjson.JSONObject;

//封装返回结果
public class ResultUtil {
    /**
     * 返回一个info为空对象的成功消息的json
     */
    public static JSONObject successJson() {
        return successJson(new JSONObject());
    }

    /**
     * 返回一个返回码为200的成功消息的json
     */
    public static JSONObject successJson(Object data) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("code",EnumCode.OK.getValue());
        resultJson.put("msg", EnumCode.OK.getText());
        resultJson.put("data", data);
        return resultJson;
    }

    /**
     * 返回错误信息JSON
     */
    public static JSONObject errorJson(EnumCode errorEnum) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("code", errorEnum.getValue());
        resultJson.put("msg", errorEnum.getText());
        resultJson.put("info", new JSONObject());
        return resultJson;
    }
}
