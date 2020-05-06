package com.watermelon.service;

import com.alibaba.fastjson.JSONArray;
import com.watermelon.entity.Course;
import com.watermelon.entity.Teacher;

import java.util.List;

public interface EvaluationService {

    JSONArray getTeachersByTeacherId(int id);
    JSONArray getTeachersBySuperId(int id);
    JSONArray getCoursesByStuId(int id);
}
