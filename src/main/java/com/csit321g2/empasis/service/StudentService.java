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

    public StudentEntity updateStudent(StudentEntity updatedStudent) {
        Optional<StudentEntity> existingStudentOptional = studentRepository.findById(updatedStudent.getSid());

        if (existingStudentOptional.isPresent()) {
            StudentEntity existingStudent = existingStudentOptional.get();

            existingStudent.setFirstname(updatedStudent.getFirstname());
            existingStudent.setLastname(updatedStudent.getLastname());
            existingStudent.setGender(updatedStudent.getGender());

            return studentRepository.save(existingStudent);
        }

        return null;
    }

    public boolean deleteStudent(int studentId) {
        Optional<StudentEntity> studentOptional = studentRepository.findById(studentId);

        if (studentOptional.isPresent()) {
            studentRepository.delete(studentOptional.get());
            return true;
        }

        return false;
    }
}
