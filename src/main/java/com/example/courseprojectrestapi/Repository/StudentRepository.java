package com.example.courseprojectrestapi.Repository;

import com.example.courseprojectrestapi.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModel, Integer> {

}
