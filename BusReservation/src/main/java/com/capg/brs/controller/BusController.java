package com.capg.brs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.brs.entity.Bus;
import com.capg.brs.service.BusServiceImpl;

@RestController
@RequestMapping("/buses")
public class BusController {

	
	@Autowired
	BusServiceImpl busService;
	
	@PostMapping("/addBus")
	public ResponseEntity<Bus> addBus(@Valid @RequestBody Bus bus) {
		busService.addBus(bus);
		return new ResponseEntity<Bus>(bus, HttpStatus.CREATED);
	}
	
	@GetMapping("/{busId}")
	public ResponseEntity<Bus> getBusById(@PathVariable Long busId) {

		Bus b = busService.getBusById(busId);

		return new ResponseEntity<Bus>(b, HttpStatus.OK);
	}
	
	@GetMapping("/allBuses")
	public ResponseEntity<List<Bus>> getAllBuses() {
		List<Bus> allBuses = busService.getAll();
		return new ResponseEntity<List<Bus>>(allBuses, HttpStatus.OK);
	}
	
	@DeleteMapping("/{busId}")
	public ResponseEntity<Bus> deleteBus(@Valid @PathVariable long busId) {
		busService.deleteBus(busId);
		return new ResponseEntity<Bus>(HttpStatus.OK);

	}
}
