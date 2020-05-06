package com.watermelon.service;

import com.alibaba.fastjson.JSONArray;

public interface EvaluationService {

    JSONArray getTeachersByTeacherId(int id);
    JSONArray getTeachersBySuperId(int id);
    JSONArray getCoursesByStuId(int id);
}
