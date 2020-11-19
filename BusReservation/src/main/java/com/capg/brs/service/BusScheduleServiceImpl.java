package com.capg.brs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.brs.entity.Schedule;
import com.capg.brs.exceptions.ScheduleDoesNotExistsException;
import com.capg.brs.repository.IBusScheduleRepository;


@Service
public class BusScheduleServiceImpl {
	@Autowired
	IBusScheduleRepository scheduleRepository;
	
	
	public Schedule addBusSchedule(Schedule busSchedule)
    {
		 return scheduleRepository.save(busSchedule);
	}
	
	
	public Schedule viewBusScheduleById(Long scheduleId) 
	{
		if (!scheduleRepository.existsById(scheduleId)) {
			throw new ScheduleDoesNotExistsException(" schedule not found");
		}
		return scheduleRepository.getSchedule(scheduleId);
	}
	
	public List<Schedule> viewAllBusSchedules()
    {	
			return scheduleRepository.findAll();
	}
	
	public void deleteBusSchedule(Long scheduleId) {
		if (!scheduleRepository.existsById(scheduleId)) {
			throw new ScheduleDoesNotExistsException(" schedule with "+scheduleId+"is not found");
		}
		scheduleRepository.deleteById(scheduleId);
		
	}


	
	

}
