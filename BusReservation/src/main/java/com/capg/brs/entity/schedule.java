package com.capg.brs.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name="schedule8")
@Entity
public class schedule {

	@Id
	private Long scheduleId;
	@ManyToOne
	private Bus bus;
	private String source;
	private String destination;
	private LocalDate arrivalTime;
	private LocalDate departureTime;
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
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
	public LocalDate getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDate arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalDate getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDate departureTime) {
		this.departureTime = departureTime;
	}
}
