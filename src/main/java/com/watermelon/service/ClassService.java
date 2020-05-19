package com.watermelon.service;

import com.watermelon.entity.Class;

import java.util.List;

public interface ClassService {

    Class getClassById(int id);

    Class getClassByName(String name);

    List<Class> listClass(int startPage, int pageSize);

    int addClass(Class classe);

    void updateClass(Class classe);

    void deleteClass(int id);

    void deleteCCourse(int id);

    int getMaxClass();
}