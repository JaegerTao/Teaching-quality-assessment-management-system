package com.watermelon.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.watermelon.entity.Course;
import com.watermelon.entity.Teacher;
import com.watermelon.mapper.EvaluationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService{
    @Autowired
    private EvaluationMapper evaluationMapper;

    @Override
    public JSONArray getTeachersByTeacherId(int id) {
        List<Teacher> teacherList = evaluationMapper.getTeachersByTeacherId(id);
        JSONArray jsonArray = new JSONArray();
        for(Teacher teacher : teacherList){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",teacher.getId());
            jsonObject.put("name",teacher.getName());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    @Override
    public JSONArray getTeachersBySuperId(int id) {
        String jsonString = JSON.toJSONString(evaluationMapper.getTeachersBySuperId(id));
        JSONArray jsonArray = JSON.parseArray(jsonString);
        return jsonArray;
    }

    @Override
    public JSONArray getCoursesByStuId(int id) {
        List<Course> courseList = evaluationMapper.getCoursesByStuId(id);
        JSONArray courseJsonArray = new JSONArray();
        JSONArray jsonArray = (JSONArray) JSON.toJSON(courseList);
        for(Object jsonObject : jsonArray){
            JSONObject newjsonObject = new JSONObject();
            JSONObject oldjsonObject = (JSONObject) ((JSONObject)jsonObject).get("teacher");
            newjsonObject.put("id",oldjsonObject.get("id"));
            newjsonObject.put("name",oldjsonObject.get("name"));
            ((JSONObject) jsonObject).put("teacher",newjsonObject);
            courseJsonArray.add(jsonObject);
        }
        return courseJsonArray;
    }
}
