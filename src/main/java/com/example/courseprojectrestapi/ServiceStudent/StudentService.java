package com.example.courseprojectrestapi.ServiceStudent;

import com.example.courseprojectrestapi.Model.StudentModel;
import com.example.courseprojectrestapi.Repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentModel> findAllStudents() {
        return studentRepository.findAll();
    }

    public StudentModel getStudentById(Integer id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + id));
    }

    @Transactional
    public StudentModel createStudent(@Valid StudentModel student){
        return studentRepository.save(student);
    }

    @Transactional
    public void deleteStudentById(Integer id){
        if(!studentRepository.existsById(id)){
            throw new EntityNotFoundException("Student with id: " + id + " cannot be found");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public StudentModel editStudentById(Integer id, StudentModel updatedStudent) {
        StudentModel existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with id: " + id));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setCourse(updatedStudent.getCourse());


        return studentRepository.save(existingStudent);
    }

}
