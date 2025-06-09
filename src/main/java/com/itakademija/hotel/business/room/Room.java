package com.itakademija.hotel.business.room;

import com.itakademija.hotel.business.reservation.Reservation;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "room")
public class Room implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String code;

    @Column(name = "number_of_beds", nullable = false)
    private Short numberOfBeds;

    @Column(nullable = false)
    private BigDecimal price;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private List<Reservation> reservations = new ArrayList<>();

    public Room() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Short getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Short numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room room)) return false;
        return Objects.equals(id, room.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
