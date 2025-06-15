package ua.opnu.practice1_template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.model.Booking;
import ua.opnu.practice1_template.repository.BookingRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public List<Booking> getBookingsByDate(LocalDate date) {
        return bookingRepository.findByDate(date);
    }

    public void cancelBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public Optional<Booking> getById(Long id) {
        return bookingRepository.findById(id);
    }
}

