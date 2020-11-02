package com.ss.lms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LoansId implements Serializable{

	
	private static final long serialVersionUID = -4656098945285105030L;

	@Column(name = "bookId", unique = true)
	private Integer bookId;
	
	@Column(name = "branchId", unique = true)
	private Integer branchId;
	
	@Column(name = "cardNo", unique = true)
	private Integer cardNo;
	
	
	public LoansId() {
		super();
	}
	public LoansId (Integer bookId, Integer branchId, Integer cardNo) {
		super();
		this.bookId = bookId;
		this.branchId = branchId;
		this.cardNo = cardNo;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CopiesId that = (CopiesId) o;
        if (!bookId.equals(that.getBookId())) return false;
        return branchId.equals(that.getBranchId());
    }
	
	
    @Override
    public int hashCode() {
        int result = bookId.hashCode();
        result = 31 * result + branchId.hashCode();
        result = 4 * result + cardNo.hashCode();
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
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public Integer getCardNo() {
		return cardNo;
	}
	public void setCardNo(Integer cardNo) {
		this.cardNo = cardNo;
	}
    
    
}
