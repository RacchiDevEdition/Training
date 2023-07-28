package com.spring.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.api.models.Test;

public interface TestRepository extends JpaRepository<Test, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM TB_TEST WHERE TEACHER_ID = ?")

	public List<Test> findByTeacherId(Long id);
}
