package ua.opnu.practice1_template.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "booking_id", unique = true)
    private Booking booking;

    private BigDecimal amount;

    private LocalDate paymentDate;

    public Payment() {}

    public Payment(Long id, Booking booking, BigDecimal amount, LocalDate paymentDate) {
        this.id = id;
        this.booking = booking;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    // Геттеры и сеттеры

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Booking getBooking() { return booking; }
    public void setBooking(Booking booking) { this.booking = booking; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDate getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDate paymentDate) { this.paymentDate = paymentDate; }
}
