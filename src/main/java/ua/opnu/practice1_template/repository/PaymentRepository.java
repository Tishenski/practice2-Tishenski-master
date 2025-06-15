package ua.opnu.practice1_template.repository;

import org.springframework.data.repository.CrudRepository;
import ua.opnu.practice1_template.model.Payment;

import java.util.Optional;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
    Optional<Payment> findByBookingId(Long bookingId);
}
