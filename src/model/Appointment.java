/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import clinicsystem.AppointmentStatus;
import clinicsystem.Doctor;
import clinicsystem.Patient;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

class Appointment {
    static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
 
    private final int id;
    private final Patient patient;
    private final Doctor doctor;
    private final LocalDateTime dateTime;
    private final String reason;
    private AppointmentStatus status;
 
    public Appointment(int id, Patient patient, Doctor doctor, LocalDateTime dateTime, String reason) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
        this.reason = reason;
        this.status = AppointmentStatus.PENDING;
    }
 
    public int getId() { return id; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public LocalDateTime getDateTime() { return dateTime; }
    public String getReason() { return reason; }
    public AppointmentStatus getStatus() { return status; }
 
    // Status can only change through these controlled methods (no public setter)
    public boolean confirm() {
        if (status == AppointmentStatus.PENDING) {
            status = AppointmentStatus.CONFIRMED;
            return true;
        }
        return false;
    }
 
    public boolean complete() {
        if (status == AppointmentStatus.CONFIRMED) {
            status = AppointmentStatus.COMPLETED;
            return true;
        }
        return false;
    }
 
    public boolean cancel() {
        if (status == AppointmentStatus.PENDING || status == AppointmentStatus.CONFIRMED) {
            status = AppointmentStatus.CANCELLED;
            return true;
        }
        return false;
    }
 
    @Override
    public String toString() {
        return String.format("Appt #%d | %s | Patient: %s | Doctor: Dr. %s | Reason: %s | Status: %s",
                id, dateTime.format(FORMAT), patient.getName(), doctor.getName(), reason, status);
    }
}