package com.spring.api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.api.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
