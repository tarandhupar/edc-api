package com.gov.travelservice.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="user")
@Table(name="user",schema="ts")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="supervisor")
	private long supervisor;
	
	@Column(name="email")
	private String email;
	
	@Column(name="created_date")
	private Date created_date;
	
	@Column(name="modified_date")
	private Date modified_date;
	
	@Column(name="modified_by")
	private String modified_by;
	
//	@OneToMany(mappedBy="requester")
//	@JsonManagedReference
//	private List<TravelRecord> travelRecordsRequesterList;
		
	@OneToMany(mappedBy="approver")
	//@JsonManagedReference
	@Where(clause="status='Pending'")
	private List<TravelRecord> approverPendingTravelRequests;
	
	@OneToMany(mappedBy="approver")
	//@JsonManagedReference
	@Where(clause="status='Approved'")
	private List<TravelRecord> approverApprovedTravelRequests;
	
//	@OneToMany(mappedBy="user")
//	@JsonManagedReference
//	private List<UserRoles> userRoles;
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(long supervisor) {
		this.supervisor = supervisor;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}
}
