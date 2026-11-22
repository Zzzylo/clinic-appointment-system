package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultationAppointment extends Appointment {

    public ConsultationAppointment(String id, Patient patient, Doctor doctor,
                                   LocalDate date, LocalTime time) throws ClinicException {
        super(id, patient, doctor, date, time);
    }

    public ConsultationAppointment(String id, Patient patient, Doctor doctor,
                                   LocalDate date, LocalTime time, String status) throws ClinicException {
        super(id, patient, doctor, date, time, status);
    }

    @Override
    public double computeFee() {
        return getDoctor().getConsultationRate();
    }

    @Override
    public String getSummary() {
        return "Consultation: " + getPatient().getName() + " with " + getDoctor().getName();
    }

    @Override
    public String getType() { return "Consultation"; }
}
