package com.csit321g2.empasis.repository;

import org.springframework.data.repository.CrudRepository;

import com.csit321g2.empasis.entity.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

}
