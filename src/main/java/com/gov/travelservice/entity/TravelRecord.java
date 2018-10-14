package com.gov.travelservice.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * 
 * @author vinodcherukuri
 *
 */
@Entity(name="travel_records")
@Table(name = "travel_records",schema="ts")
public class TravelRecord  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="requester", insertable=false,updatable=false)
	@JsonBackReference
	private User requester;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="approver", insertable=false,updatable=false)
	@JsonBackReference
	private User approver;

	@Column(name="status")
	private String status;
	
	@Column(name="date_from")
	private Date travelDateFrom;
	
	@Column(name="date_to")
	private Date travelDateTo;
	
	@Column(name="location_from")
	private String travelLocationFrom;
	
	@Column(name="location_to")
	private String travelLocationTo;
	
	@Column(name="air_fare")
	private Double airFare;
	
	@Column(name="mileage")
	private Double mileage;
	
	@Column(name="hotel")
	private Double hotel;
	
	@Column(name="rentCar")
	private Double rentCar;
	
	@Column(name="perDiem")
	private Double perDiem;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="modified_Date")
	private Date modifiedDate;
	
	@Column(name="modified_by")
	private String modifiedBy;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTravelDateFrom() {
		return travelDateFrom;
	}

	public void setTravelDateFrom(Date travelDateFrom) {
		this.travelDateFrom = travelDateFrom;
	}

	public Date getTravelDateTo() {
		return travelDateTo;
	}

	public void setTravelDateTo(Date travelDateTo) {
		this.travelDateTo = travelDateTo;
	}

	public String getTravelLocationFrom() {
		return travelLocationFrom;
	}

	public void setTravelLocationFrom(String travelLocationFrom) {
		this.travelLocationFrom = travelLocationFrom;
	}

	public String getTravelLocationTo() {
		return travelLocationTo;
	}

	public void setTravelLocationTo(String travelLocationTo) {
		this.travelLocationTo = travelLocationTo;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public User getRequester() {
		return requester;
	}

	public void setRequester(User requester) {
		this.requester = requester;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getApprover() {
		return approver;
	}

	public void setApprover(User approver) {
		this.approver = approver;
	}

	public Double getAirFare() {
		return airFare;
	}

	public void setAirFare(Double airFare) {
		this.airFare = airFare;
	}

	public Double getMileage() {
		return mileage;
	}

	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}

	public Double getHotel() {
		return hotel;
	}

	public void setHotel(Double hotel) {
		this.hotel = hotel;
	}

	public Double getRentCar() {
		return rentCar;
	}

	public void setRentCar(Double rent_car) {
		this.rentCar = rent_car;
	}

	public Double getPerDiem() {
		return perDiem;
	}

	public void setPerDiem(Double per_diem) {
		this.perDiem = per_diem;
	}
}
