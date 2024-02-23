package com.boot.studentproject.business.abstracts;

import com.boot.studentproject.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    Student addStudent(Student student);
    Student updateStudent(Student student, Long id);
    Student getStudentById(Long id);
    void deleteStudent(Long id);
}
