package org.kanishka.onclinicwebbackend.model;

import org.bson.types.ObjectId;
import org.kanishka.onclinicwebbackend.model.reports.Media;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Appointment {
    @Id
    private ObjectId _id;
    private String patientEmail;
    private String doctorEmail;
    private List<Media> prefferedMedia;
    private String generalQuery;
    private String appointmentDate;
    private String timeslot;
    private AppointmentStatus status;
    private String dateTime;
    private String firebaseId;

    private String doctorName;
    private String patientName;

    public Appointment() {
    }

    public Appointment(ObjectId _id, String patientEmail, String doctorEmail, List<Media> prefferedMedia, String generalQuery, String timeslot, AppointmentStatus status, String dateTime) {
        this._id = _id;
        this.patientEmail = patientEmail;
        this.doctorEmail = doctorEmail;
        this.prefferedMedia = prefferedMedia;
        this.generalQuery = generalQuery;
        this.timeslot = timeslot;
        this.status = status;
        this.dateTime = dateTime;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public List<Media> getPrefferedMedia() {
        return prefferedMedia;
    }

    public void setPrefferedMedia(List<Media> prefferedMedia) {
        this.prefferedMedia = prefferedMedia;
    }

    public String getGeneralQuery() {
        return generalQuery;
    }

    public void setGeneralQuery(String generalQuery) {
        this.generalQuery = generalQuery;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getFirebaseId() {
        return firebaseId;
    }

    public void setFirebaseId(String firebaseId) {
        this.firebaseId = firebaseId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
