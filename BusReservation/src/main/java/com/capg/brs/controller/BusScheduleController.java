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

import com.capg.brs.entity.Schedule;
import com.capg.brs.service.BusScheduleServiceImpl;


@RestController
@RequestMapping("/schedules")
public class BusScheduleController {
	
	@Autowired
	BusScheduleServiceImpl busSchedule;
	
	@PostMapping("/addSchedule")
	public ResponseEntity<Schedule> addBusSchedule(@Valid @RequestBody Schedule schedule) {
		busSchedule.addBusSchedule(schedule);
		return new ResponseEntity<Schedule>(schedule, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{scheduleId}")
	public ResponseEntity<Schedule> viewBusScheduleById(@PathVariable Long scheduleId) {

		Schedule s = busSchedule.viewBusScheduleById(scheduleId);

		return new ResponseEntity<Schedule>(s, HttpStatus.OK);
	}
	
	@GetMapping("/allSchedules")
	public ResponseEntity<List<Schedule>> viewAllBusSchedules() {
		List<Schedule> allSchedules = busSchedule.viewAllBusSchedules();
		return new ResponseEntity<List<Schedule>>(allSchedules, HttpStatus.OK);
		}
	
	@DeleteMapping("/{scheduleId}")
	public ResponseEntity<Schedule> deleteSchedule(@Valid @PathVariable Long scheduleId) {
		busSchedule.deleteBusSchedule(scheduleId);
		return new ResponseEntity<Schedule>(HttpStatus.OK);

	}
}
