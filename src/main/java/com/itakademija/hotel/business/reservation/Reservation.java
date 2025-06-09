package com.itakademija.hotel.business.reservation;

import com.itakademija.hotel.business.reservation.guest.Guest;
import com.itakademija.hotel.business.room.Room;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "from_date", nullable = false)
    private LocalDateTime fromDate;

    @Column(name = "to_date", nullable = false)
    private LocalDateTime toDate;

    @Column(name = "checkin", nullable = false)
    private boolean checkin;

    @Column(name = "checkin_date_time")
    private LocalDateTime checkinDateTime;

    @Column(name = "checkout")
    private boolean checkout;

    @Column(name = "checkout_date_time")
    private LocalDateTime checkoutDateTime;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "status")
    private Short status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_guest", referencedColumnName = "id")
    private Guest mainGuest;

//    @ManyToMany
//    @JoinTable(
//            name = "reservation_guest",
//            joinColumns = @JoinColumn(name = "id_reservation"),
//            inverseJoinColumns = @JoinColumn(name = "id_guest")
//    )
//    @OrderColumn(name = "id_guest")//Hibernate throws Cannot fetch multiple bags
//    private List<Guest> guests = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "reservation_guest",
            joinColumns = @JoinColumn(name = "id_reservation"),
            inverseJoinColumns = @JoinColumn(name = "id_guest")
    )
    private Set<Guest> guests = new HashSet<>();


    @ManyToOne(optional = false)
    @JoinColumn(name = "id_room", referencedColumnName = "id")
    private Room room;

    public Reservation() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }

    public boolean isCheckin() {
        return checkin;
    }

    public void setCheckin(boolean checkin) {
        this.checkin = checkin;
    }

    public LocalDateTime getCheckinDateTime() {
        return checkinDateTime;
    }

    public void setCheckinDateTime(LocalDateTime checkinDateTime) {
        this.checkinDateTime = checkinDateTime;
    }

    public boolean isCheckout() {
        return checkout;
    }

    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
    }

    public LocalDateTime getCheckoutDateTime() {
        return checkoutDateTime;
    }

    public void setCheckoutDateTime(LocalDateTime checkoutDateTime) {
        this.checkoutDateTime = checkoutDateTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Guest getMainGuest() {
        return mainGuest;
    }

    public void setMainGuest(Guest mainGuest) {
        this.mainGuest = mainGuest;
    }

    public Set<Guest> getGuests() {
        return guests;
    }

    public void setGuests(Set<Guest> guests) {
        this.guests = guests;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
