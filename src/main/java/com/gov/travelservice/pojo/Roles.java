package com.gov.travelservice.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="roles")
@Table(name="roles",schema="ts")
public class Roles implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="role_id")
	private long id;
	
	@Column(name="role_name")
	private String roleName;
	
	/*@OneToOne
    @JoinColumn(name="role_id", insertable=false,updatable=false)
	@JsonBackReference
	private UserRoles role;*/
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="role_id", insertable=false,updatable=false)
	@JsonBackReference
	private UserRoles roles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserRoles getRoles() {
		return roles;
	}

	public void setRoles(UserRoles roles) {
		this.roles = roles;
	}


}
