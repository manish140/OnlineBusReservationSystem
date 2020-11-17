package com.capg.brs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="bus8")
@Entity
public class Bus {
	
	
	@Id
	private Long busId;
	private String busNumber;
	private String busOperator;
	private String busType;
	private Long seatCapacity;
	private Double fare;
	
	public Long getBusId() {
		return busId;
	}
	public void setBusId(Long busId) {
		this.busId = busId;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getBusOperator() {
		return busOperator;
	}
	public void setBusOperator(String busOperator) {
		this.busOperator = busOperator;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public Long getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(Long seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}
	
}
