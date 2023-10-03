package com.csit321g2.empasis.repository;

import org.springframework.data.repository.CrudRepository;
import com.csit321g2.empasis.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
