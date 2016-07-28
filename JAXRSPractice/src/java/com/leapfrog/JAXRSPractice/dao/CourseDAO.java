/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.JAXRSPractice.dao;

import com.leapfrog.JAXRSPractice.entity.Course;
import java.util.List;

/**
 *
 * @author Manjul Sigdel
 */
public interface CourseDAO {
    void insert(Course c);
    void update(Course c);
    boolean delete(int id);
    Course getByID(int id);
    List<Course> getAll();
} 
