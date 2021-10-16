package com.example.springmongodb.service.student;


import com.example.springmongodb.entity.Student.Student;
import com.example.springmongodb.repository.student.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }
}
