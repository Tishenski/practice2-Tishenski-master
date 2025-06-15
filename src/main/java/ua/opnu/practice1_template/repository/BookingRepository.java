package ua.opnu.practice1_template.repository;

import org.springframework.data.repository.CrudRepository;
import ua.opnu.practice1_template.model.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);
    List<Booking> findByDate(LocalDate date);
}

