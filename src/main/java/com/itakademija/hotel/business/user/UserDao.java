package com.itakademija.hotel.business.user;

import com.itakademija.hotel.business.Dao;
import com.itakademija.hotel.business.EMFHolder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.Query;

import java.util.Collections;
import java.util.List;

public class UserDao implements Dao<User, Integer> {
    @Override
    public void save(User entity) {

    }

    @Override
    public User findBy(Integer primaryKey) {
        return null;
    }

    @Override
    public List<User> findAll() {
        EntityManagerFactory emf = EMFHolder.entityManagerFactory();
        try (EntityManager entityManager = emf.createEntityManager();) {
            Query query = entityManager.createNamedQuery("User.findAll");
            List<User> users = (List<User>) query.getResultList();
            return users;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void delete(User entity) {

    }


    //username i password: null , user
    public User login(String username, String password) {
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            return null;
        }
        EntityManagerFactory emf = EMFHolder.entityManagerFactory();
        try (EntityManager entityManager = emf.createEntityManager();) {
            Query query = entityManager.createNamedQuery("User.findByUsernameAndPassword");
            User user = (User) query
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
            return user;
        } catch (NonUniqueResultException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
