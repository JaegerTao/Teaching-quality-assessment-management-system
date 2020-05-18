package com.watermelon.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.watermelon.entity.Course;
import com.watermelon.entity.IndividualEvaluation;
import com.watermelon.entity.Teacher;

import java.util.List;
import java.util.Map;


public interface EvaluationService {
    /**
     * 获取教师需要评价的教师列表
     * @param id
     * @return
     */
    List<Course> getCoursesByTeacherId(int id);

    /**
     * 获取督导需要评价的教师列表
     * @param id
     * @return
     */
    List<Course> getCoursesBySuperId(int id);

    /**
     * 获取学生需要评价的课程（包括老师）列表
     * @param id
     * @return
     */
    List<Course> getCoursesByStuId(int id);


    List<Course> getCoursesByStuId(int id, int startPage, int pageSize);
    List<Course> getCoursesBySuperId(int id, int startPage, int pageSize);
    List<Course> getCoursesByTeacherId(int id, int startPage, int pageSize);

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

    //获取老师总评价
    List<Map> getSummaryEvaluation(int teacherId,int courseId);

}
