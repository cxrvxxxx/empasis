package com.csit321g2.empasis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csit321g2.empasis.entity.StudentEntity;
import com.csit321g2.empasis.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/add")
    // @ModelAttribute -> Maps all type attributes as RequestParams
    public ResponseEntity<Integer> addStudent(@ModelAttribute StudentEntity s) {
        studentRepository.save(s);
        return new ResponseEntity<Integer>(s.getSid(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<StudentEntity>> getAllStudents() {
        return new ResponseEntity<Iterable<StudentEntity>>(studentRepository.findAll(), HttpStatus.OK);
    }
}
