package com.dinesh.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dinesh.spring.data.jpa.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>
{

}
