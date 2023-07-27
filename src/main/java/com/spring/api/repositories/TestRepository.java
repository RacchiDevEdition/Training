package com.spring.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.api.models.Test;
import com.spring.api.pk.TestPk;

public interface TestRepository extends JpaRepository<Test, TestPk> {

	@Query(nativeQuery = true, value = "SELECT * FROM TB_TEST INNER JOIN TB_TEACHER ON ID WHERE TEACHER_ID = ID")
	public List<Test> findByTeacher(Long id);
}
