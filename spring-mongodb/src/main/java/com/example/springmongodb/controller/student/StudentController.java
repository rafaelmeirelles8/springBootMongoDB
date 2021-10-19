package com.example.springmongodb.controller.student;

import com.example.springmongodb.entity.Student.Student;
import com.example.springmongodb.service.student.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> fetchAllStudents() {
        return studentService.fetchAllStudents();
    }

    @PostMapping
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStudent(@PathVariable("id") String id){
        studentService.deleteById(id);
    }

    @PutMapping(path = "/{id}")
    public void updateStudent(@PathVariable("id") String id, @RequestParam(required = false) String firstName) {
        studentService.updateStudent(id, firstName);
    }

}
