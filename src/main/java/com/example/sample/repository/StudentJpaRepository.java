package com.example.sample.repository;

import com.example.sample.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository extends JpaRepository<Student, Integer> {
}
