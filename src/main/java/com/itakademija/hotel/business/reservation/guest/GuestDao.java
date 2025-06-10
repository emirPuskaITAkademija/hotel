package com.itakademija.hotel.business.reservation.guest;

import com.itakademija.hotel.business.AbstractDao;
import com.itakademija.hotel.business.EMFHolder;
import jakarta.persistence.EntityManager;

public class GuestDao extends AbstractDao<Guest, Integer> {

    public GuestDao() {
        super(Guest.class);
    }

    @Override
    public EntityManager entityManager() {
        return EMFHolder.entityManagerFactory().createEntityManager();
    }
}
