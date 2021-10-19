package com.example.springmongodb.repository.student;

import com.example.springmongodb.entity.Student.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {

     //@Query("SELECT s FROM Student s WHERE s.email = ?1")
     Optional<Student> findStudentByEmailEquals(String email);

}
