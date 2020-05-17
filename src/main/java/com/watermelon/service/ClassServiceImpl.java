package com.watermelon.service;

import com.watermelon.entity.Class;
import com.watermelon.mapper.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClassServiceImpl implements ClassService{
    @Autowired
    private ClassMapper classMapper;
    @Override
    public Class getClassById(int id) {
        return classMapper.getClassById(id);
    }

    @Override
    public Class getClassByName(String name) {
        return classMapper.getClassByName(name);
    }

    @Override
    public List<Class> listClass() {
        return classMapper.listClass();
    }

    @Override
    public int addClass(Class classe) {
        return classMapper.addClass(classe);
    }

    @Override
    public void updateClass(Class classe) {
       classMapper.updateClass(classe);
    }

    @Override
    public void deleteClass(int id) {
    classMapper.deleteClass(id);
    }

    @Override
    public int getMaxClass() {
        return classMapper.getMaxClassId();
    }
}
