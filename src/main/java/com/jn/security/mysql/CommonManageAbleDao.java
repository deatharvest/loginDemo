package com.jn.security.mysql;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class CommonManageAbleDao {

    @PersistenceContext(unitName = "depotnearbyEntityManagerFactory")
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
