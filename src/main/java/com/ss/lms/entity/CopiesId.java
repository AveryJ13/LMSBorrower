package com.ss.lms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CopiesId implements Serializable {

	private static final long serialVersionUID = -7188168013551473589L;

	@Column(name = "bookId", unique = true)
	private Integer bookId;
	
	@Column(name = "branchId", unique = true)
	private Integer branchId;
	
	public CopiesId() {
		super();
	}
	public CopiesId (Integer bookId, Integer branchId) {
		super();
		this.bookId = bookId;
		this.branchId = branchId;
	}
	
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CopiesId that = (CopiesId) o;
        if (!bookId.equals(that.bookId)) return false;
        return branchId.equals(that.branchId);
    }
    @Override
    public int hashCode() {
        int result = bookId.hashCode();
        result = 31 * result + branchId.hashCode();
        return result;
    }
	
    public Integer getBookId() {
    	return bookId;
    }
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getBranchId() {
		return branchId;
	}
	public void setId(Integer branchId) {
		this.branchId = branchId;
	}


}
