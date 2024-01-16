package com.example.courseprojectrestapi.Repository;

import com.example.courseprojectrestapi.Model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseModel, Integer> {
}
