package com.ss.lms.repo;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ss.lms.entity.Loans;

@Repository
public interface LoansRepo extends JpaRepository<Loans, Id>{
	@Query(" FROM Loans where bookId =:bookId and branchId =:branchId and cardNo =:cardNo")
	public List<Loans> readLoansById(@Param("bookId") Integer bookId, @Param("branchId") Integer branchId, @Param("cardNo") Integer CardNo);
	
	
	@Query(" FROM Loans where cardNo =:cardNo")
	public List<Loans> readLoansByCardNo(@Param("cardNo") Integer cardNo);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE tbl_book_loans SET dueDate = date_add(current_timestamp(), interval 2 week) WHERE cardNo = :cardNo and bookId = :bookId and branchId = :branchId", nativeQuery = true)	
	public void overrideDueDate(@Param("cardNo") Integer cardNo, @Param("bookId") Integer bookId, @Param("branchId") Integer branchId);

	
	//
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value ="INSERT INTO tbl_book_loans (cardNo, bookId, branchId, dateOut, dueDate) "
			+ "values (:cardNo, :bookId, :branchId,  current_timestamp(), date_add(current_timestamp(), interval 2 week))", nativeQuery = true)
	public void addLoan(@Param("cardNo") Integer cardNo, @Param("bookId") Integer bookId, @Param("branchId") Integer branchId);
}
