package org.kanishka.onclinicwebbackend.repository;

import org.bson.types.ObjectId;
import org.kanishka.onclinicwebbackend.model.Appointment;
import org.kanishka.onclinicwebbackend.model.AppointmentStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, ObjectId> {
    Optional<Appointment> getAppointmentByFirebaseId(String firebaseId);
    Appointment getAppointmentBy_id(String _id);
    Optional<List<Appointment>> getAppointmentsByPatientEmailAndDateTime(String patientEmail, String dateTime);
    Optional<List<Appointment>> getAppointmentsByPatientEmailAndStatus(String patientEmail, AppointmentStatus status);
    Optional<List<Appointment>> getAppointmentsByDoctorEmailAndStatus(String patientEmail, AppointmentStatus status);
    Optional<List<Appointment>> getAppointmentsByDoctorEmailAndAppointmentDateAndStatusNotIn(String doctorEmail, String appointmentDate, List<AppointmentStatus> statuses);
}
