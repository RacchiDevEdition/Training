package com.spring.api.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.spring.api.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query(nativeQuery = true, value = "SELECT STUDENT_ID FROM TB_STUDENT INNER JOIN TB_COURSE WHERE COURSE_ID = ?")
	List<Student> findByCourse( Long id);
}
