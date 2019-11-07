package com.wss.demo.repository;

import com.wss.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentReporitory extends JpaRepository<Student,Integer> {
}
