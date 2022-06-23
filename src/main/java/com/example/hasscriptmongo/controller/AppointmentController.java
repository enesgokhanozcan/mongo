package com.example.hasscriptmongo.controller;
import com.example.hasscriptmongo.dto.AppointmentDto;
import com.example.hasscriptmongo.model.Appointment;
import com.example.hasscriptmongo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping
    public Appointment addAppointment(@Valid@RequestBody AppointmentDto appointmentDto){
        return  appointmentService.addAppointment(appointmentDto);
    }
    @GetMapping("/{userId}")
    public List<Appointment> findByUserId(@PathVariable("userId") String userId){
        return appointmentService.findByUserId(userId);
    }
}
