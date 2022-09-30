package com.practice.mysqlcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.mysqlcrud.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
