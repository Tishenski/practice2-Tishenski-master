package ua.opnu.practice1_template.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Workspace workspace;

    @ManyToOne
    private User user;

    private LocalDate date;

    private String timeSlot;

    private Boolean paid;

    public Booking() {}

    public Booking(Long id, Workspace workspace, User user, LocalDate date, String timeSlot, Boolean paid) {
        this.id = id;
        this.workspace = workspace;
        this.user = user;
        this.date = date;
        this.timeSlot = timeSlot;
        this.paid = paid;
    }

    // Геттеры и сеттеры

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Workspace getWorkspace() { return workspace; }
    public void setWorkspace(Workspace workspace) { this.workspace = workspace; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getTimeSlot() { return timeSlot; }
    public void setTimeSlot(String timeSlot) { this.timeSlot = timeSlot; }

    public Boolean getPaid() { return paid; }
    public void setPaid(Boolean paid) { this.paid = paid; }
}

