package com.boot.studentproject.business.concretes;

import com.boot.studentproject.business.abstracts.StudentService;
import com.boot.studentproject.business.rules.StudentBusinessRules;
import com.boot.studentproject.dataAccess.StudentRepository;
import com.boot.studentproject.entities.Student;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentManager implements StudentService {
    private StudentRepository studentRepository;
    private StudentBusinessRules studentBusinessRules;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        studentBusinessRules.checkIfStudentEmailExists(student.getEmail());
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student newStudent, Long id) {

        Optional<Student> student = studentRepository.findById(id);

        if(student.isPresent()) {
            Student foundStudent = student.get();
            foundStudent.setFirstName(newStudent.getFirstName());
            foundStudent.setLastName(newStudent.getLastName());
            foundStudent.setEmail(newStudent.getEmail());
            foundStudent.setDepartments(newStudent.getDepartments());
            return studentRepository.save(foundStudent);
        } else {
            studentBusinessRules.studentNotFound("Student could not be found!");
            return null;
        }

    }

    @Override
    public Student getStudentById(Long id) {
        boolean isExists = studentRepository.findById(id).isPresent();

        if(!isExists) {
            studentBusinessRules.studentNotFound("Student could not be found!");
            return null;
        } else {
            return studentRepository.findById(id).orElseThrow();
        }

    }

    @Override
    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id)) {
            studentBusinessRules.studentNotFound("Student could not be found!");
        } else {
            studentRepository.deleteById(id);
        }
    }
}
