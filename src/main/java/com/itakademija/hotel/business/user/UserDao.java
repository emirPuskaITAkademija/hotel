package com.itakademija.hotel.business.user;

import com.itakademija.hotel.business.AbstractDao;
import com.itakademija.hotel.business.EMFHolder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.Query;

public class UserDao extends AbstractDao<User, Integer> {

    public UserDao() {
        super(User.class);
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

    @Override
    public EntityManager entityManager() {
        return EMFHolder.entityManagerFactory().createEntityManager();
    }
}
