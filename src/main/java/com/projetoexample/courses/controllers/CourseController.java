package com.projetoexample.courses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
  public ResponseEntity<?> findById(@PathVariable Long id) {
    try {
      Course course = this.courseRepository.findById(id).orElseThrow();
      return ResponseEntity.status(HttpStatus.OK).body(course);
    } catch (Exception e) {
      String errorMessage = "Course with id " + id + " Not found!";
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
  }

  @GetMapping
  public List<Course> findAll() {
    return this.courseService.findAll();
  }

  @PostMapping
  public ResponseEntity<Course> create(@Valid @RequestBody Course course) {
    return ResponseEntity.status(HttpStatus.CREATED).body(this.courseRepository.save(course));
  }

}
