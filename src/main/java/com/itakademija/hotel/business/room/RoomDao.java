package com.itakademija.hotel.business.room;

import com.itakademija.hotel.business.AbstractDao;
import com.itakademija.hotel.business.EMFHolder;
import jakarta.persistence.EntityManager;

public class RoomDao extends AbstractDao<Room, Integer> {
    public RoomDao() {
        super(Room.class);
    }

    @Override
    public EntityManager entityManager() {
        return EMFHolder.entityManagerFactory().createEntityManager();
    }
}
