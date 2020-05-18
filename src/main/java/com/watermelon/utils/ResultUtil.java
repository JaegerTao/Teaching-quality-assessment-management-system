package com.watermelon.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

//封装返回结果
@JsonInclude(JsonInclude.Include.NON_NULL)  //非空才会序列化
@Data
public class ResultUtil {
    private Integer code;
    private String msg;
    private Object data;
    private Object info;
    /**
     * 返回一个info为空对象的成功消息的json
     */
    public static ResultUtil success() {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(EnumCode.OK.getValue());
        resultUtil.setMsg(EnumCode.OK.getText());
        return resultUtil;
    }

    /**
     * 返回一个返回码为200的成功消息的
     */
    public static ResultUtil success(Object data) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(EnumCode.OK.getValue());
        resultUtil.setMsg(EnumCode.OK.getText());
        resultUtil.setData(data);
        return resultUtil;
    }

    /**
     * 返回错误信息
     */
    public static ResultUtil error(EnumCode errorEnum) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(errorEnum.getValue());
        resultUtil.setMsg(errorEnum.getText());
        return resultUtil;
    }

    public static ResultUtil error(EnumCode errorEnum,Object info) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(errorEnum.getValue());
        resultUtil.setMsg(errorEnum.getText());
        resultUtil.setInfo(info);
        return resultUtil;
    }
}
