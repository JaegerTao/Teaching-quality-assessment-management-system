package com.watermelon.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.watermelon.entity.Course;
import com.watermelon.entity.IndividualEvaluation;
import com.watermelon.entity.Teacher;
import com.watermelon.mapper.EvaluationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EvaluationServiceImpl implements EvaluationService{
    @Autowired
    private EvaluationMapper evaluationMapper;

    @Override
    public List<Course> getCoursesByTeacherId(int id) {
        return evaluationMapper.getCoursesByTeacherId(id);
    }

    @Override
    public List<Course> getCoursesBySuperId(int id) {
        return evaluationMapper.getCoursesBySuperId(id);
    }

    @Override
    public List<Course> getCoursesByStuId(int id) {
        return evaluationMapper.getCoursesByStuId(id);
    }

// 分页查询课程
    @Override
    public List<Course> getCoursesByStuId(int id, int startPage, int pageSize) {
        Page<Course> p = new Page<>(startPage,pageSize);
        p.setRecords(evaluationMapper.getCoursesByStuIdWithPage(id, p));
        return p.getRecords();
    }

    @Override
    public List<Course> getCoursesBySuperId(int id, int startPage, int pageSize) {
        Page<Course> p = new Page<>(startPage,pageSize);
        return evaluationMapper.getCoursesBySuperIdWithPage(id, p);
    }

    @Override
    public List<Course> getCoursesByTeacherId(int id, int startPage, int pageSize) {
        Page<Course> p = new Page<>(startPage,pageSize);
        return evaluationMapper.getCoursesByTeacherIdWithPage(id, p);
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

    @Override
    public List<Map> getSummaryEvaluation(int teacherId,int courseId) {
        return evaluationMapper.getSummaryEvaluation(teacherId,courseId);
    }
}
