package com.ada_locate.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Integer dailyRental;
    private Boolean isOpen;

    public Rent(Client client, Integer dailyRental) {
        this.client = client;
        this.checkIn = LocalDateTime.now();
        this.dailyRental = dailyRental;
        this.checkOut = LocalDateTime.now().plusDays(dailyRental);
        this.isOpen = true;
    }

    public Rent() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public LocalDateTime getCheckIn() {
        return checkIn;
    }
    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }
    public LocalDateTime getCheckOut() {
        return checkOut;
    }
    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }
    public Integer getDailyRental() {
        return dailyRental;
    }
    public void setDailyRental(Integer dailyRental) {
        this.dailyRental = dailyRental;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    
}
