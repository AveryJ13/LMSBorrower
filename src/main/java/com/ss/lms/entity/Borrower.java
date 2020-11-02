package com.ss.lms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="tbl_borrower")
public class Borrower implements Serializable {
//    private Integer cardNo;
//    private String name;
//    private String address;
//    private String phone;
//
//    public Borrower(Integer cardNo, String name, String address, String phone){
//        this.cardNo = cardNo;
//        this.name = name;
//        this.address = address;
//        this.phone = phone;
//    }
//
//    public Integer getCardNo(){return cardNo;}
//    public String getName(){return name;}
//    public String getAddress(){return address;}
//    public String getPhone(){return phone;}
//
//    public void setCardNo(Integer cardNo){this.cardNo = cardNo;}
//    public void setName(String name){this.name = name;}
//    public void setAddress(String address){this.address = address;}
//    public void setPhone(String phone){this.phone = phone;}
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cardNo")
	private Integer cardNo;
	
	@Column(name = "name")
	@NonNull
	private String name;
	
	@Column(name = "address")
	@NonNull
	private String address;
	
	@Column(name = "phone")
	@NonNull
	private String phone;
	
	
	public Integer getCardNo(){return cardNo;}
   public String getName(){return name;}
   public String getAddress(){return address;}
   public String getPhone(){return phone;}

   public void setCardNo(Integer cardNo){this.cardNo = cardNo;}
   public void setName(String name){this.name = name;}
   public void setAddress(String address){this.address = address;}
   public void setPhone(String phone){this.phone = phone;}

}
