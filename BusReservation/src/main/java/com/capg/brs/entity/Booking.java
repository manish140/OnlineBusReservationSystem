package com.capg.brs.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Table(name="booking8")
@Entity
public class Booking {
       
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long bookingId;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "busId", nullable = false)
	private Bus busId;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "userId", nullable = true)
	private User userId;
	
	
	private String source;
	private String destination;
	private LocalDate dateOfJourney;
	private Double ticketCost;
	private Integer noOfPassengers;
	public Long getBookingId() {
		return bookingId;
	}
	
	
	public Booking(Long bookingId,Bus busId,User userId,String source, String destination,LocalDate dateOfJourney,Double ticketCost,Integer noOfPassengers) {
		super();
	  this.bookingId=bookingId;
	  this.busId=busId;
	  this.source=source;
	  this.destination=destination;
	  this.dateOfJourney=dateOfJourney;
	  this.noOfPassengers=noOfPassengers;
	}
   
	public Booking() {
		super();
	}
	
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}
	public Bus getBusId() {
		return busId;
	}
	public void setBusId(Bus busId) {
		this.busId = busId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}
	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}
	public Double getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(Double ticketCost) {
		this.ticketCost = ticketCost;
	}
	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	
	

	


	

	

	
}
