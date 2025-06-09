package com.itakademija.hotel.business.country.town;

import com.itakademija.hotel.business.country.Country;
import com.itakademija.hotel.business.country.town.address.Address;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "town")
public class Town implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_country", referencedColumnName = "id")
    private Country country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "town")
    private List<Address> addresses = new ArrayList<>();

    public Town() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Town town)) return false;
        return Objects.equals(id, town.id) && Objects.equals(name, town.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
