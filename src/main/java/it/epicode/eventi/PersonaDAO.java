package it.epicode.eventi;

import jakarta.persistence.EntityManager;

public class PersonaDAO {

    private EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void insertPersona(Persona persona) {

        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
    }
}
