package com.spring.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.api.models.ClassRoom;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
	
	//gettind duplicated values
	@Query(nativeQuery = true, value = "SELECT * FROM TB_CLASSROOM_TEACHER JOIN TB_TEACHER ON ID WHERE TEACHER_ID = ?")
	List<ClassRoom> findTeacherByClass(Long id);
	
}