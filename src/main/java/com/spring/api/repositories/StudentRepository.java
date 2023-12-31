package com.spring.api.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.spring.api.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM TB_STUDENT JOIN TB_COURSE ON ID = COURSE_ID WHERE ID = ?")	
	List<Student> findByCourse (Long id);
}
