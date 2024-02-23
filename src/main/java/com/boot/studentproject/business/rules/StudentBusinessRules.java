package com.boot.studentproject.business.rules;

import com.boot.studentproject.core.utilities.exceptions.BusinessException;
import com.boot.studentproject.dataAccess.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentBusinessRules {
    private StudentRepository studentRepository;

    public void checkIfStudentEmailExists(String email) {
        if(this.studentRepository.existsByEmail(email)) {
            throw new BusinessException(email + " already exists");
        }
    }

    public void studentNotFound(String message) {
        throw new BusinessException(message);
    }
}
