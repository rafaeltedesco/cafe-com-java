package com.projetoexample.courses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoexample.courses.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
