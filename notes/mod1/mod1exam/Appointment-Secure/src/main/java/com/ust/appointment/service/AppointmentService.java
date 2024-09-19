package com.ust.appointment.service;

import com.ust.appointment.model.Appointment;
import com.ust.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;


    public Appointment save(Appointment appointment) {

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findAll() {

        return appointmentRepository.findAll();
    }

    public Appointment findById(Long id) {

        return appointmentRepository.findById(id).orElse(null);
    }







}
