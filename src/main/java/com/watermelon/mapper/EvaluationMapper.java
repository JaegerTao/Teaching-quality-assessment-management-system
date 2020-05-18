package com.watermelon.mapper;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.watermelon.entity.Course;
import com.watermelon.entity.IndividualEvaluation;
import com.watermelon.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EvaluationMapper {
    // 获取可评价的课程老师列表
    List<Course> getCoursesByTeacherId(int id);
    List<Course> getCoursesByStuId(int id);
    List<Course> getCoursesBySuperId(int id);

    List<Course> getCoursesByStuIdWithPage(int id, Page<Course> page);
    List<Course> getCoursesByTeacherIdWithPage(int id, Page<Course> page);
    List<Course> getCoursesBySuperIdWithPage(int id, Page<Course> page);

    //获取对应个人评价
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

    // 添加个人评价
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

    //获取教师总评价
    List<Map> getSummaryEvaluation(int teacherId,int courseId);

}
