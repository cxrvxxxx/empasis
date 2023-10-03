package com.csit321g2.empasis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csit321g2.empasis.model.Student;
import com.csit321g2.empasis.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/add")
    public @ResponseBody String addStudent(
            @RequestParam String name,
            @RequestParam String email) {
        Student s = new Student();
        s.setName(name);
        s.setEmail(email);
        studentRepository.save(s);
        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
