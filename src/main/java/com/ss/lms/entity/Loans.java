package com.ss.lms.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_book_loans")
public class Loans  implements Serializable{
   

//    public Loans(Integer bookId, Integer branchId, Integer cardNo, String dateOut, String dueDate, String dateIn, String title){
//        this.bookId = bookId;
//        this.branchId = branchId;
//        this.cardNo = cardNo;
//        this.dateOut = dateOut;
//        this.dueDate = dueDate;
//        this.dateIn = dateIn;
//        this.title = title;
//    }


	private static final long serialVersionUID = -7781234005501507758L;
	
	public Loans() {
		super();
	}
	
	public Loans(LoansId id) {
		super();
		this.id = id;
	}
	
	@EmbeddedId
	private LoansId id;
	
	@Column(name="dateIn")
	private String dateIn;
	
	@Column(name="dueDate")
	private String dueDate;
	
	@Column(name="dateOut")
	private String dateOut;

	@ManyToOne
	@JoinColumn(name = "bookId", insertable=false, updatable=false)
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "branchId", insertable=false, updatable=false)
	private Branch branch;
	
	@ManyToOne
	@JoinColumn(name="cardNo", insertable=false, updatable=false)
	private Borrower borrower;

	
	
	
	public LoansId getId() {
		return id;
	}

	public void setId(LoansId id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public String getDateIn() {
		return dateIn;
	}

	public void setDateIn(String dateIn) {
		this.dateIn = dateIn;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getDateOut() {
		return dateOut;
	}

	public void setDateOut(String dateOut) {
		this.dateOut = dateOut;
	}
	
	
}
