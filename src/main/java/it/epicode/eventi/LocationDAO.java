package it.epicode.eventi;

import jakarta.persistence.EntityManager;

public class LocationDAO {


    private EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void insertLocation(Location location) {

        if (!em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        em.getTransaction().begin();
        em.persist(location);
        em.getTransaction().commit();
    }
}