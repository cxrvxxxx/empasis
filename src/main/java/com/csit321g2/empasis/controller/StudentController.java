package com.csit321g2.empasis.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csit321g2.empasis.entity.StudentEntity;
import com.csit321g2.empasis.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<StudentEntity> addStudent(@RequestBody StudentEntity s) {
        return new ResponseEntity<StudentEntity>(studentService.addStudent(s), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<StudentEntity>> getAllStudents() {
        return new ResponseEntity<Iterable<StudentEntity>>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Optional<StudentEntity>> getStudent(@PathVariable int studentId) {
        return new ResponseEntity<Optional<StudentEntity>>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<StudentEntity> updateStudent(@RequestBody StudentEntity updatedStudent) {
        StudentEntity updated = studentService.updateStudent(updatedStudent);

        if (updated != null) {
            return new ResponseEntity<StudentEntity>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<StudentEntity>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int studentId) {
        boolean deleted = studentService.deleteStudent(studentId);

        if (deleted) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
