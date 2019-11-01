package org.kanishka.onclinicwebbackend.controller;

import org.kanishka.onclinicwebbackend.model.*;
import org.kanishka.onclinicwebbackend.repository.AppointmentRepository;
import org.kanishka.onclinicwebbackend.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consultation")
@CrossOrigin(origins = "https://4409a0f0.ngrok.io")
public class ConsultationController {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("doctors")
    public Optional<List<Users>> getAllDoctors(){
        return this.userRepository.findByRolesContainingAndHealthCareProfessionalEquals(Roles.ROLE_DOCTOR, true);
    }

    @GetMapping("appointment/{id}")
    public Appointment getAppointmentByFirebaseId(@PathVariable("id") String appointmentId){
        return this.appointmentRepository.getAppointmentByFirebaseId(appointmentId).get();
    }

    @PostMapping("appointment")
    public Appointment placeAppointment(@RequestBody Appointment appointment){
        return this.appointmentRepository.save(appointment);
    }

    @GetMapping("patients/appointment/{patientEmail}")
    public Optional<List<Appointment>> getAllAppointmentsByPatientEmailAndAppointmentStatus(@PathVariable String patientEmail,@RequestParam("status") AppointmentStatus status){
        return this.appointmentRepository.getAppointmentsByPatientEmailAndStatus(patientEmail,status);
    }

    @GetMapping("doctors/appointment/{doctorEmail}")
    public Optional<List<Appointment>> getAllAppointmentsByDoctorEmailAndAppointmentStatus(@PathVariable String doctorEmail,@RequestParam("status") AppointmentStatus status){
        return this.appointmentRepository.getAppointmentsByDoctorEmailAndStatus(doctorEmail,status);
    }

    @PutMapping("appointment")
    public Appointment updateAppointment(@RequestBody Appointment appointment){
        return this.appointmentRepository.save(appointment);
    }

    @GetMapping("availability/{doctorEmail}/{appointmentDate}")
    public TimeSlot getNextTimeSlot(@PathVariable String appointmentDate, @PathVariable String doctorEmail){
        Users doctor = this.userRepository.findByEmail(doctorEmail).orElse(new Users());
        Optional<List<Appointment>> appointments=this.appointmentRepository.getAppointmentsByDoctorEmailAndAppointmentDateAndStatusNotIn(doctorEmail,appointmentDate, Arrays.asList(AppointmentStatus.COMPLETE,AppointmentStatus.REJECTED));
        List<TimeSlot> doctorDailyAvailableTimeSlots = doctor.getAvailableTimeSlots().stream().map(timeslot -> {
            String day = timeslot.split("D")[0];
            String fromTime = (timeslot.split("D")[1]).split("--")[0];
            String toTime = (timeslot.split("D")[1]).split("--")[1];
            return TimeSlot.getInstance(day, fromTime, toTime);

        }).collect(Collectors.toList());

        LocalDate appointmentDateLocalDate=LocalDate.parse(appointmentDate);
        String appointmentDay= appointmentDateLocalDate.getDayOfWeek().name();
        List<TimeSlot> appointmentDayTimeSlotList = doctorDailyAvailableTimeSlots.stream().filter(timeSlot -> {
            return timeSlot.getDay().equalsIgnoreCase(appointmentDay);
        }).collect(Collectors.toList());
        TimeSlot appointmentDayTimeSlot=appointmentDayTimeSlotList.get(0);
        LocalTime starterFromTime= LocalTime.parse(appointmentDayTimeSlot.getTimePeriod().getFrom());

        LocalTime newFromTime = starterFromTime.plusMinutes(15*(appointments.orElse(Arrays.asList()).size()+1));
        LocalTime newToTime = newFromTime.plusMinutes(15);
        return TimeSlot.getInstance(appointmentDay.toLowerCase(),newFromTime.toString(),newToTime.toString());

    }
}
