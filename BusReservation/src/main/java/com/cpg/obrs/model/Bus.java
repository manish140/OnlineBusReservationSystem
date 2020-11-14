package com.cpg.obrs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="bus8")
@Entity
public class Bus {
	
	
	@Id
	private Long busId;
	private String busOperator;
	private Long seatCapacity;
	private Double fare;
	public Long getBusId() {
		return busId;
	}
	public void setBusId(Long busId) {
		this.busId = busId;
	}
	public String getBusOperator() {
		return busOperator;
	}
	public void setBusOperator(String busOperator) {
		this.busOperator = busOperator;
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
