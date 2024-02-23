package com.boot.studentproject.webApi.controllers;

import com.boot.studentproject.business.abstracts.StudentService;
import com.boot.studentproject.entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class StudentController {
    private final StudentService studentService;

    @GetMapping()
    public ResponseEntity<List<Student>> getAll() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.FOUND);
    }

    @PostMapping()
    public Student addStudent(@RequestBody() Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody() Student student, @PathVariable Long id) {
        return studentService.updateStudent(student, id);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void DeleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
