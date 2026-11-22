package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class FollowUpAppointment extends Appointment {
    private static final double DISCOUNT = 0.5; // example discount, the group decides

    public FollowUpAppointment(String id, Patient patient, Doctor doctor,
                               LocalDate date, LocalTime time) throws ClinicException {
        super(id, patient, doctor, date, time);
    }

    public FollowUpAppointment(String id, Patient patient, Doctor doctor,
                               LocalDate date, LocalTime time, String status) throws ClinicException {
        super(id, patient, doctor, date, time, status);
    }

    @Override
    public double computeFee() {
        return getDoctor().getConsultationRate() * DISCOUNT;
    }

    @Override
    public String getSummary() {
        return "Follow-up: " + getPatient().getName() + " with " + getDoctor().getName();
    }

    @Override
    public String getType() { return "Follow-up"; }
}
