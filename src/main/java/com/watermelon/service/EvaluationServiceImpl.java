package com.watermelon.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.watermelon.entity.Course;
import com.watermelon.entity.IndividualEvaluation;
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
    public JSONArray getCoursesByTeacherId(int id) {
        List<Course> courseList = evaluationMapper.getCoursesByTeacherId(id);
        System.out.println(courseList);
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

    @Override
    public JSONArray getCoursesBySuperId(int id) {
        String jsonString = JSON.toJSONString(evaluationMapper.getCoursesBySuperId(id));
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

    @Override
    public IndividualEvaluation getSuperIndiEvaluation(int superId, int teacherId, int courseId) {
        return evaluationMapper.getSuperIndiEvaluation(superId,teacherId,courseId);
    }

    @Override
    public IndividualEvaluation getTeacherIndiEvaluation(int fromTeacherId, int toTeacherId, int courseId) {
        return evaluationMapper.getTeacherIndiEvaluation(fromTeacherId,toTeacherId,courseId);
    }

    @Override
    public IndividualEvaluation getStudentIndiEvaluation(int studentId, int teacherId, int courseId) {
        return evaluationMapper.getStudentIndiEvaluation(studentId,teacherId,courseId);
    }

    @Override
    public int addStudentIndiEvaluation(IndividualEvaluation individualEvaluation) {
        return evaluationMapper.addStudentIndiEvaluation(individualEvaluation);
    }

    @Override
    public int addTeacherIndiEvaluation(IndividualEvaluation individualEvaluation) {
        return evaluationMapper.addTeacherIndiEvaluation(individualEvaluation);
    }

    @Override
    public int addSuperIndiEvaluation(IndividualEvaluation individualEvaluation) {
        return evaluationMapper.addSuperIndiEvaluation(individualEvaluation);
    }
}
