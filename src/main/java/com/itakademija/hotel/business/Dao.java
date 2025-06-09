package com.itakademija.hotel.business;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.function.Function;

public interface Dao<E, PK> {
    void save(E entity);

    E findBy(PK primaryKey);

    List<E> findAll();

    E update(E entity);

    void delete(E entity);

    default <R> R executeInTransaction(Function<EntityManager, R> function) {
        EntityManagerFactory emf = EMFHolder.entityManagerFactory();
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            try {
                R result = function.apply(em);
                em.getTransaction().commit();
                return result;
            } catch (Exception exception) {
                em.getTransaction().rollback();
                throw new RuntimeException(exception);
            }
        }
    }

}
