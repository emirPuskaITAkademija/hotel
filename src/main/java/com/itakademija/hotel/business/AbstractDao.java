package com.itakademija.hotel.business;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

import java.util.List;
import java.util.function.Function;

public abstract class AbstractDao<E, PK> {

    private final Class<E> entityClass;

    public AbstractDao(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public abstract EntityManager entityManager();

    public void save(E entity) {
        Function<EntityManager, E> saveFunction = em -> {
            em.persist(entity);
            return entity;
        };
        executeInTransaction(saveFunction);
    }

    public E findBy(PK primaryKey) {
        try (EntityManager em = entityManager()) {
            return em.find(entityClass, primaryKey);
        }
    }

    public List<E> findAll() {
        try (EntityManager em = entityManager()) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<E> cq = cb.createQuery(entityClass);
            cq.select(cq.from(entityClass));
            return em.createQuery(cq).getResultList();
        }
    }

    public E update(E entity) {
        Function<EntityManager, E> updateFunction = em -> {
            em.merge(entity);
            return entity;
        };
        return executeInTransaction(updateFunction);
    }

    public void delete(E entity) {
        Function<EntityManager, E> deleteFunction = em -> {
            if (!em.contains(entity)) {
                E mergedEntity = em.merge(entity);
                em.remove(mergedEntity);
                return mergedEntity;
            } else {
                em.remove(entity);
                return entity;
            }
        };
        executeInTransaction(deleteFunction);
    }

    private E executeInTransaction(Function<EntityManager, E> function) {
        try (EntityManager em = entityManager()) {
            em.getTransaction().begin();
            try {
                E result = function.apply(em);
                em.getTransaction().commit();
                return result;
            } catch (Exception exception) {
                em.getTransaction().rollback();
                throw new RuntimeException(exception);
            }
        }
    }

}
