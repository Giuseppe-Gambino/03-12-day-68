package it.epicode.eventi;

import jakarta.persistence.EntityManager;

public class EventoDAO {


    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void insertEvento(Evento evento) {


        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
    }

    public Evento getById(Long id){
        return em.find(Evento.class, id);
    }

    public void delete(Long id) {
        Evento evento = getById(id);
        em.getTransaction().begin();
        em.remove(evento);
        em.getTransaction().commit();
    }
}
