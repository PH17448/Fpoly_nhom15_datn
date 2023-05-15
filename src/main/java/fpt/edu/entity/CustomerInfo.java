package fpt.edu.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "customer_infos")
public class CustomerInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(100) not null")
	private String customerName;
	
	@Column(name = "phone_number")
	private Integer phoneNumber;
	
	@Column(columnDefinition = "varchar(100) not null")
	private String address;
	
	@Column(columnDefinition = "varchar(100) not null")
	private String email;
	
	@Column(name = "created_by", columnDefinition = "nvarchar(100) not null")
	private String createdBy;
	
	@Column(name = "created_time")
	private Instant createdTime;
	
	@Column(name = "last_modifed_by", columnDefinition = "nvarchar(100) not null")
	private String lastModifedBy;
	
	@Column(name = "last_modifed_time")
	private Instant lastModifedTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Instant getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Instant createdTime) {
		this.createdTime = createdTime;
	}

	public String getLastModifedBy() {
		return lastModifedBy;
	}

	public void setLastModifedBy(String lastModifedBy) {
		this.lastModifedBy = lastModifedBy;
	}

	public Instant getLastModifedTime() {
		return lastModifedTime;
	}

	public void setLastModifedTime(Instant lastModifedTime) {
		this.lastModifedTime = lastModifedTime;
	}
	
	
}
