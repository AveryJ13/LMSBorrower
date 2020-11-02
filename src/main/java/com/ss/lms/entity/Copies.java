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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "tbl_book_copies")
public class Copies implements Serializable{

	
	private static final long serialVersionUID = 4204807339381623404L;

	public Copies() {
		super();
	}
	
	public Copies(CopiesId id) {
		super();
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "bookId", insertable=false, updatable=false)
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "branchId", insertable=false, updatable=false)
	private Branch branch;
	
	
	
	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Book getBook() {
		return book;
	}

	public void setBooks(Book book) {
		this.book = book;
	}

	@EmbeddedId
	private CopiesId id;
   
	
	@Column(name = "noOfCopies")
	private Integer noOfCopies;



	public Integer getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	public CopiesId getId() {
		return id;
	}

	public void setId(CopiesId id) {
		this.id = id;
	}





}
