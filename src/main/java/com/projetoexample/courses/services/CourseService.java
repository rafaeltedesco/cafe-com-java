package com.projetoexample.courses.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoexample.courses.entities.Course;
import com.projetoexample.courses.repositories.CourseRepository;

@Service
public class CourseService {
  
  @Autowired
  private CourseRepository courseRepository;

  public List<Course> findAll() {
    return this.courseRepository.findAll();
  }

}
