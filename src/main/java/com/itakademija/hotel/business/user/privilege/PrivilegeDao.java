package com.itakademija.hotel.business.user.privilege;

import com.itakademija.hotel.business.AbstractDao;
import com.itakademija.hotel.business.EMFHolder;
import jakarta.persistence.EntityManager;

public class PrivilegeDao extends AbstractDao<Privilege, Integer> {

    public PrivilegeDao() {
        super(Privilege.class);
    }

    @Override
    public EntityManager entityManager() {
        return EMFHolder.entityManagerFactory().createEntityManager();
    }
}
