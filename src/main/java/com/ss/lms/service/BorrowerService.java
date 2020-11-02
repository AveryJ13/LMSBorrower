package com.ss.lms.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ss.lms.entity.Copies;
import com.ss.lms.entity.Loans;
import com.ss.lms.repo.CopiesRepo;
import com.ss.lms.repo.LoansRepo;

@RestController
public class BorrowerService {

  @Autowired 
  LoansRepo lrepo;
  
  @Autowired
  CopiesRepo crepo;
  
  //Read all loans by card number

		@RequestMapping(value = "/getLoansByCardNo", method = RequestMethod.GET, produces = "application/json")
		public List<Loans> getLoansByCardNo(@RequestParam Integer cardNo) {
			List<Loans> loans = new ArrayList<>();
			if(cardNo != null) {
				loans = lrepo.readLoansByCardNo(cardNo);
			} else {
				loans = lrepo.findAll();
			}
			return loans;
		}
   
  //Checkout a book
  @Transactional
	@RequestMapping(value = "/addLoan", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public List<Loans> AddLoan(@RequestParam Integer cardNo, @RequestParam Integer bookId, @RequestParam Integer branchId){
	  		//updating copies
	  		List<Copies> oldCopies = crepo.readCopiesById(bookId, branchId);
	  		oldCopies.get(0).setNoOfCopies((oldCopies.get(0).getNoOfCopies() - 1));
	  		crepo.save(oldCopies.get(0));
	  		//adding loan
			lrepo.addLoan(cardNo, bookId, branchId);
			
			return lrepo.findAll();
	}
  //Return a book
  @Transactional
	@RequestMapping(value = "/deleteLoan", method = RequestMethod.DELETE, produces = "application/json", consumes = "application/json")
	public List<Loans> deleteLoan(@RequestBody Loans loan) throws SQLException {
	  			//updating copies
				List<Copies> oldCopies = crepo.readCopiesById(loan.getId().getBookId(), loan.getId().getBranchId());
				oldCopies.get(0).setNoOfCopies((oldCopies.get(0).getNoOfCopies() + 1));
				crepo.save(oldCopies.get(0));
				
				//returning book/deleting
				lrepo.delete(loan);
				return lrepo.findAll();
				
	}
  
  
  




}
