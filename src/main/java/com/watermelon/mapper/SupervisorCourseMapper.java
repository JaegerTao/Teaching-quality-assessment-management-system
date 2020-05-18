package com.watermelon.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SupervisorCourseMapper {

    // 设置督导可评价的课程老师
    /**
     * 添加督导可评价的课程老师
     * @param supervisorId
     * @param courseId
     * @param teacherId
     * @return
     */
    int addSupervisorCourse(int supervisorId, int courseId, int teacherId);

    /**
     * 删除督导可评价的课程老师
     * @param supervisorId
     * @param courseId
     * @param teacherId
     * @return
     */
    int deleteSupervisorCourse(int supervisorId, int courseId, int teacherId);

}
