package com.capg.brs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.brs.entity.Bus;
import com.capg.brs.exceptions.BusExistsException;
import com.capg.brs.exceptions.BusNotFoundException;
import com.capg.brs.repository.IBusRepository;

@Service
public class BusServiceImpl {
	@Autowired
	IBusRepository busRepository;
	
	public Bus addBus (Bus bus) {
		  if(busRepository.existsById(bus.getBusId())) {
			 throw new BusExistsException("Bus Already Exits");
		  }
		 return busRepository.save(bus);
	  }	
	
	public Bus getBusById(Long busId) {
		// TODO Auto-generated method stub
		if (!busRepository.existsById(busId)) {
			throw new BusNotFoundException(" Bus not found");
		}
		return busRepository.getBus(busId);
	}
	

	public List<Bus> getAll(){	
		return busRepository.findAll();
	}

	
	public void deleteBus(Long busId) {
		 if(!busRepository.existsById(busId)) {
			 throw new BusNotFoundException("BusId with "+busId+" is NOT FOUND");
		 }
		busRepository.deleteById(busId);
	 }
}
