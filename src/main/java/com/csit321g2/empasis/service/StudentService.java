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

    public boolean addStudent(StudentEntity s) {
        studentRepository.save(s);
        return true;
    }

    public Iterable<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<StudentEntity> getStudentById(int studentId) {
        return studentRepository.findById(studentId);
    }
}
