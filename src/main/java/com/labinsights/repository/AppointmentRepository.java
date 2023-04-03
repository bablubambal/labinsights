package com.labinsights.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.labinsights.entity.Appointment;
import com.labinsights.entity.User;

 
@Repository("appointmentRepository")
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
	
	@Query("select u from Appointment u  where u.userid = :userId")
	List<Appointment> findAppointmentsByUserId(String userId);
	
	@Query("select u from Appointment u  where u.id = :id")
	Appointment findAppointmentByInteger(Integer id);

	
}