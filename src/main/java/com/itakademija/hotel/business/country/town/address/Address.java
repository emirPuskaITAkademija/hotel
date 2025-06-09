package com.itakademija.hotel.business.country.town.address;

import com.itakademija.hotel.business.country.town.Town;
import com.itakademija.hotel.business.reservation.guest.Guest;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "street", length = 45, nullable = false)
    private String street;

    @Column(name = "number", length = 45, nullable = false)
    private String number;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_town", referencedColumnName = "id")
    private Town town;

    @OneToMany(mappedBy = "address")
    private List<Guest> guests = new ArrayList<>();

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
