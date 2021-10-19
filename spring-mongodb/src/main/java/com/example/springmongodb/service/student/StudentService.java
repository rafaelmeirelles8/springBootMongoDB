package com.example.springmongodb.service.student;


import com.example.springmongodb.entity.Student.Student;
import com.example.springmongodb.repository.student.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public Student getById(String id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteById(String id){
        studentRepository.deleteById(id);
    }

    public void createStudent(Student newStudent) {
        studentRepository.findStudentByEmailEquals(newStudent.getEmail()).
                ifPresentOrElse(student -> {
                            throw new IllegalStateException(String.format("Student already exists with the email: %s", student.getEmail()));
                        },
                        () -> studentRepository.save(newStudent));
    }

    @Transactional
    public void updateStudent(String id, String firstName) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException(String.format("Student %s does not exist!", id)));
        student.setFirstName(firstName);
        studentRepository.save(student);
    }

}
