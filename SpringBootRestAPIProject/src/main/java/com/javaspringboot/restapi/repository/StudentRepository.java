package com.javaspringboot.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspringboot.restapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
