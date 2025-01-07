package com.prasanth.cruddemo.dao;

import com.prasanth.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);
}
