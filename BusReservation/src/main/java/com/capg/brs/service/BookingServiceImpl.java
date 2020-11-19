package com.capg.brs.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.brs.entity.Booking;
import com.capg.brs.entity.Bus;
import com.capg.brs.entity.Route;
import com.capg.brs.entity.Schedule;
import com.capg.brs.entity.User;
import com.capg.brs.exceptions.BookingNotFoundException;
import com.capg.brs.exceptions.RouteDoesNotExistsException;
import com.capg.brs.exceptions.ScheduleDoesNotExistsException;
import com.capg.brs.repository.IBookingRepository;
import com.capg.brs.repository.IBusRepository;
import com.capg.brs.repository.IRouteRepository;
import com.capg.brs.repository.IBusScheduleRepository;

@Service
public class BookingServiceImpl implements IBookingService {

	
	@Autowired
	 IBookingRepository bookingRepository;
	@Autowired
	IRouteRepository routeRepository;
	@Autowired
	IBusScheduleRepository scheduleRepository;
	@Autowired
	IBusRepository busRepository;
	
	
	public Booking addBooking(Booking booking) {
    Route   routeId=routeRepository.findBySourceAndDestination(booking.getSource(),booking.getDestination());
     if(routeId==null)
    	 throw new RouteDoesNotExistsException("Route not found");
     else {
    	Schedule schedule=scheduleRepository.findByRouteIdAndArrivalTime(routeId,booking.getDateOfJourney());
    	 if(schedule==null)
    		 throw new ScheduleDoesNotExistsException("No buses available");
    	 else {
    		 Double fare=busRepository.findFareByBusId(schedule);
    		Double ticketCost=booking.getNoOfPassengers()*fare;
    		bookingRepository.update(booking.getUserId(),ticketCost);
    		
    		int availableSeats=busRepository.findSeatCapacityByBusId(schedule);
    		busRepository.updateAvailableSeats(schedule,availableSeats);
    	 }
    	 }
    
   
		return  bookingRepository.save(booking);
	}

	@Override
	public Booking getBookingById(Long bookingId) {
		if (!bookingRepository.existsById(bookingId)) {
			throw new BookingNotFoundException(" booking not found");
		}
		return bookingRepository.getBooking(bookingId);
	}

	@Override
	public List<Booking> getAllBookings() {
		
			return bookingRepository.findAll();
		
	}

	@Override
	public void deleteBooking(Long bookingId) {
		if(!bookingRepository.existsById(bookingId)) {
			 throw new BookingNotFoundException("BookingId with "+bookingId+" is NOT FOUND");
		 }
		 bookingRepository.deleteById(bookingId);
	}

}
