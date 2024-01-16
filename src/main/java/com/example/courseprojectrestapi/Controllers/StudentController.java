package com.example.courseprojectrestapi.Controllers;

import com.example.courseprojectrestapi.Model.StudentModel;
import com.example.courseprojectrestapi.ServiceStudent.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentModel> getAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentModel> getStudentById(@PathVariable Integer id) {
        StudentModel student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<StudentModel> registerStudent(@RequestBody StudentModel student) {
        StudentModel newStudent = studentService.createStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentModel> editStudent(@PathVariable Integer id, @RequestBody StudentModel student) {
        StudentModel updatedStudent = studentService.editStudentById(id, student);
        return ResponseEntity.ok(updatedStudent);
    }
}
