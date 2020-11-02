package com.ss.lms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ss.lms.entity.Branch;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Integer> {
	@Query(" FROM Branch where branchId =:branchId")
	public List<Branch> readBranchesById(@Param("branchId") Integer branchId);
	
	@Query(" FROM Branch where branchName =:branchName")
	public List<Branch> readBranchByName(@Param("branchName") String branchName);
	
	@Query(" FROM Branch where branchAddress =:branchAddress")
	public List<Branch> readBranchByAddress(@Param("branchAddress") String branchAddress);
	
}
