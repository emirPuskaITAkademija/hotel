package com.itakademija.hotel.business.reservation;

import com.itakademija.hotel.business.AbstractDao;
import com.itakademija.hotel.business.EMFHolder;
import jakarta.persistence.EntityManager;

public class ReservationDao extends AbstractDao<Reservation, Integer> {

    public ReservationDao() {
        super(Reservation.class);
    }

    @Override
    public EntityManager entityManager() {
        return EMFHolder.entityManagerFactory().createEntityManager();
    }
}
