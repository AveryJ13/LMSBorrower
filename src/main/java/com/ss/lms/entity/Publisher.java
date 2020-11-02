package com.ss.lms.entity;



import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tbl_publisher")
public class Publisher  implements Serializable{
//    private Integer publisherId;
//    private String publisherName;
//    private String publisherAddress;
//    private String publisherPhone;
//
//    public Publisher(Integer publisherId, String publisherName, String publisherAddress, String publisherPhone) {
//        this.publisherId = publisherId;
//        this.publisherName = publisherName;
//        this.publisherAddress = publisherAddress;
//        this.publisherPhone = publisherPhone;
//    }

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8184826810978075500L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "publisherId")
	private Integer publisherId;
	
	@Column(name = "publisherName")
	private String publisherName;
	
	@Column(name = "publisherAddress")
	private String publisherAddress;
	
	@Column(name = "publisherPhone")
	private String publisherPhone;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "publisher")
	@JsonBackReference
	private List<Book> books;
	
    public Integer getPublisherId() {
        return publisherId;
    }
    
    public void setPublisherId(Integer publisherId) {
    	this.publisherId = publisherId;
    }

    
    public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}


	public String getPublisherName(){
        return publisherName;
    }

    public String getPublisherAddress(){
        return publisherAddress;
    }

    public String getPublisherPhone(){
        return publisherPhone;
    }

    public void setPublisherName(String publisherName){
        this.publisherName= publisherName;
    }

    public void setPublisherAddress(String publisherAddress){
        this.publisherAddress = publisherAddress;
    }

  

    public void setPublisherPhone(String publisherPhone) {
        this.publisherPhone = publisherPhone;
    }

}
