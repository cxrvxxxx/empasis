package com.csit321g2.empasis.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.csit321g2.empasis.entity.StudentEntity;
import com.csit321g2.empasis.repository.StudentRepository;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentEntity addStudent(StudentEntity s) {
        return studentRepository.save(s);
    }

    public Iterable<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<StudentEntity> getStudentById(int studentId) {
        return studentRepository.findById(studentId);
    }
}
