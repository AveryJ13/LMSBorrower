package com.ss.lms.entity;

import java.util.List;
import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "tbl_book")
public class Book implements Serializable {

	
	private static final long serialVersionUID = -1158699696440751729L;
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookId")
	private Integer bookId;
	
	@Column(name = "title")
	@NonNull
	private String title;
	
	@ManyToMany
	@JoinTable(name = "tbl_book_authors", joinColumns = {@JoinColumn(name="bookId")},
	inverseJoinColumns = {@JoinColumn(name="authorId")})
	private List<Author> authors;
	
	@ManyToOne
	@JoinColumn(name = "pubId")
	private Publisher publisher;
	
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Integer getBookId() {
		return bookId;
	}
	
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
}
