package it.epicode.dao;

import it.epicode.entity.Partecipazione;
import jakarta.persistence.EntityManager;

public class PartecipazioneDAO {

    private EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void insertPartecipazione(Partecipazione partecipazione) {


        em.getTransaction().begin();
        em.persist(partecipazione);
        em.getTransaction().commit();
    }
}
