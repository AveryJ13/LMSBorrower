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
@Table(name = "tbl_library_branch")
public class Branch implements Serializable{
//    private Integer branchId;
//    private String branchName;
//    private String branchAddress;
//
//    public Branch(Integer branchId, String branchName, String branchAddress){
//        this.branchId = branchId;
//        this.branchName = branchName;
//        this.branchAddress = branchAddress;
//    }

	
	private static final long serialVersionUID = -2111496642319240844L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "branchId")
	private Integer branchId;
	
	@Column(name = "branchName")
	@NonNull
	private String branchName;
	
	@Column(name = "branchAddress")
	@NonNull
	private String branchAddress;
	
    public Integer getBranchId(){
        return branchId;
    }

    public String getBranchName(){
        return branchName;
    }

    public String getBranchAddress(){
        return branchAddress;
    }

    public void setBranchName(String branchName){
       this.branchName = branchName;
    }

    public void setBranchId(Integer branchId){
        this.branchId = branchId;
    }

    public void setBranchAddress(String branchAddress){
        this.branchAddress = branchAddress;
    }

}
