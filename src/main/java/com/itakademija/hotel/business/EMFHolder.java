package com.itakademija.hotel.business;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMFHolder {
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory entityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence
                    .createEntityManagerFactory("hotelPU");
        }
        return entityManagerFactory;
    }
}
