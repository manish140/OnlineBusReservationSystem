package com.capg.brs.service;

import org.springframework.http.ResponseEntity;

import com.capg.brs.entity.Bus;

public interface IBusService {
	public ResponseEntity<?> addBus(Bus bus);

	public Iterable<Bus> viewAllBuses();

	public Bus viewBus(Long busId);

	

	public String removeBus(Long busId);
}
