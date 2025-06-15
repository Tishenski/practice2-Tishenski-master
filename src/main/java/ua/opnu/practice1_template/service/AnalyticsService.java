package ua.opnu.practice1_template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.model.Booking;
import ua.opnu.practice1_template.model.Payment;
import ua.opnu.practice1_template.repository.BookingRepository;
import ua.opnu.practice1_template.repository.PaymentRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AnalyticsService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Long> getAvailableWorkspaceIds(LocalDate date) {
        List<Long> all = StreamSupport.stream(bookingRepository.findAll().spliterator(), false)
                .map(b -> b.getWorkspace().getId())
                .distinct()
                .collect(Collectors.toList());

        List<Long> booked = bookingRepository.findByDate(date).stream()
                .map(b -> b.getWorkspace().getId())
                .distinct()
                .collect(Collectors.toList());

        all.removeAll(booked);
        return all;
    }

    public long getBookingCountByWorkspace(Long workspaceId) {
        return StreamSupport.stream(bookingRepository.findAll().spliterator(), false)
                .filter(b -> b.getWorkspace().getId().equals(workspaceId))
                .count();
    }

    public List<String> getPopularTimeSlots() {
        return StreamSupport.stream(bookingRepository.findAll().spliterator(), false)
                .collect(Collectors.groupingBy(Booking::getTimeSlot, Collectors.counting()))
                .entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<String, BigDecimal> getIncomeByWorkspace() {
        return StreamSupport.stream(paymentRepository.findAll().spliterator(), false)
                .collect(Collectors.groupingBy(
                        p -> p.getBooking().getWorkspace().getName(),
                        Collectors.mapping(Payment::getAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                ));
    }

    public List<Long> getMostActiveUsers() {
        return StreamSupport.stream(bookingRepository.findAll().spliterator(), false)
                .collect(Collectors.groupingBy(b -> b.getUser().getId(), Collectors.counting()))
                .entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<Month, Long> getMonthlyBookingStats() {
        return StreamSupport.stream(bookingRepository.findAll().spliterator(), false)
                .collect(Collectors.groupingBy(
                        b -> b.getDate().getMonth(),
                        Collectors.counting()
                ));
    }
}
