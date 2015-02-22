package com.billapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@Entity
@Table(name = "contractor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Contractor implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private long contractorId;
	@Column(name = "email")
	
	private String emailId;
	public long getContractorId() {
		return contractorId;
	}
	public void setContractorId(long contractorId) {
		this.contractorId = contractorId;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
