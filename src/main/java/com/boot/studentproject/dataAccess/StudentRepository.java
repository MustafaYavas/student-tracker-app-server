package com.boot.studentproject.dataAccess;

import com.boot.studentproject.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByEmail(String email);
}
