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


    IPage<Course> getCoursesByStuId(Integer id, Integer startPage, Integer pageSize,String courseName);
    IPage<Course> getCoursesBySuperId(Integer id, Integer startPage, Integer pageSize,String courseName);
    IPage<Course> getCoursesByTeacherId(Integer id, Integer startPage, Integer pageSize,String courseName);
    IPage getCoursesByAdmin(Integer startPage,Integer pageSize,String courseNmae);

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

    //获取某教师的所有课程
    IPage<Course> getCoursesOfTeacher(int teacherId,int startPage,int pageSize);

    //获取教师某门课程的建议
    IPage getAdvices(int teacherId,int courseId,int roleId,int startPage,int pageSize);

    //查看某老师是否已经评价了某门课程
    Integer ifEvaluated(Integer fromId, Integer teacherId, Integer courseId);
}
