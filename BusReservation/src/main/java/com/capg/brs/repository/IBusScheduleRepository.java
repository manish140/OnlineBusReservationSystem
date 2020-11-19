package com.capg.brs.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.brs.entity.Route;
import com.capg.brs.entity.Schedule;

public interface IBusScheduleRepository extends JpaRepository<Schedule, Long>{

  @Query("select busId from Schedule u where routeId=?1 and arrivalTime=?1")
	Schedule findByRouteIdAndArrivalTime(Route routeId,LocalDate dateOfJourney);

  @Query("select u from Schedule u where sheduleId=?1")
  public Schedule getSchedule(Long scheduleId);
}
