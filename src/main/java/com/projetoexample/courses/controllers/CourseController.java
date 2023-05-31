package com.projetoexample.courses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projetoexample.courses.entities.Course;
import com.projetoexample.courses.repositories.CourseRepository;
import com.projetoexample.courses.services.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private CourseService courseService;
  
  @GetMapping("/{id}")
  public Course findById(@PathVariable Long id) {
    Course course = this.courseRepository.findById(id).orElseThrow();
    return course;
  }

  @GetMapping
  public List<Course> findAll() {
    return this.courseService.findAll();
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Course create(@Valid @RequestBody Course course) {
    Course newCourse = this.courseRepository.save(course);
    return newCourse;
  }

}
