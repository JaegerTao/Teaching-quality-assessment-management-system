package com.watermelon.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.watermelon.entity.Course;
import com.watermelon.entity.IndividualEvaluation;
import com.watermelon.entity.Teacher;

import java.util.List;

public interface EvaluationService {
    /**
     * 获取教师需要评价的教师列表
     * @param id
     * @return
     */
    JSONArray getCoursesByTeacherId(int id);

    /**
     * 获取督导需要评价的教师列表
     * @param id
     * @return
     */
    JSONArray getCoursesBySuperId(int id);

    /**
     * 获取学生需要评价的课程（包括老师）列表
     * @param id
     * @return
     */
    JSONArray getCoursesByStuId(int id);

    /**
     * 获取督导的个人评价
     * @param superId
     * @param teacherId
     * @return
     */
    IndividualEvaluation getSuperIndiEvaluation(int superId, int teacherId, int courseId);

    /**
     * 获取教师的个人评价
     * @param fromTeacherId
     * @param toTeacherId
     * @return
     */
    IndividualEvaluation getTeacherIndiEvaluation(int fromTeacherId, int toTeacherId, int courseId);

    /**
     * 获取学生的个人评价
     * @param studentId
     * @param teacherId
     * @return
     */
    IndividualEvaluation getStudentIndiEvaluation(int studentId, int teacherId, int courseId);

    /**
     * 添加学生的个人评价
     */
    int addStudentIndiEvaluation(IndividualEvaluation individualEvaluation);

    /**
     * 添加老师的个人评价
     */
    int addTeacherIndiEvaluation(IndividualEvaluation individualEvaluation);

    /**
     * 添加督导的个人评价
     */
    int addSuperIndiEvaluation(IndividualEvaluation individualEvaluation);

}
