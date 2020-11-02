package com.ss.lms.repo;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ss.lms.entity.Copies;

@Repository
public interface CopiesRepo extends JpaRepository<Copies, Id>{
	
	@Query(" FROM Copies ")
	public List<Copies> readCopies();
	
	@Query(" FROM Copies where bookId =:bookId and branchId =:branchId")
	public List<Copies> readCopiesById(@Param("bookId") Integer bookId, @Param("branchId") Integer branchId);
}
