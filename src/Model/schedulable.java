package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public interface Schedulable {
    void reschedule(LocalDate newDate, LocalTime newTime) throws ClinicException;
    void cancel() throws ClinicException;
    boolean isActive();
    
}
