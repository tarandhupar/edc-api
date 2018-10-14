package com.gov.travelservice.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gov.travelservice.entity.User;

@Entity(name="user_roles")
@Table(name="user_roles",schema="ts")
public class UserRoles implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="uid", insertable=false,updatable=false)
	@JsonBackReference
	private User user;
	
	@OneToMany(mappedBy="roles")
	@JsonManagedReference
	private List<Roles> roles;
	
	/*@OneToOne
	@JsonManagedReference
	@JoinColumn(name="role_id", insertable=false,updatable=false)
	private Roles roles;*/
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	

}
