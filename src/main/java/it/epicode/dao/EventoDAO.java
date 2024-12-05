package it.epicode.dao;

import it.epicode.entity.Concerto;
import it.epicode.entity.Evento;
import it.epicode.entity.Genere;
import jakarta.persistence.EntityManager;

import java.util.List;

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

    public List<Concerto> getConcertiInStreaming(Boolean bool) {
        return em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming", Concerto.class)
                .setParameter("inStreaming",bool)
                .getResultList();
    }

    public void stampConcertiInStreaming(Boolean bool) {
        for (Concerto concerto : getConcertiInStreaming(bool)) {
            System.out.println("ID Evento: " + concerto.getId());
            System.out.println("Titolo Evento: " + concerto.getTitolo());
            System.out.println("Data Evento: " + concerto.getDataEvento());
            System.out.println("Descrizione Evento: " + concerto.getDescrizione());
            System.out.println("Genere Concerto: " + concerto.getGenere());
            System.out.println("In Streaming: " + concerto.getInStreaming());
            System.out.println("Tipo Evento: " + concerto.getTipoEvento());
            System.out.println("Numero massimo partecipanti: " + concerto.getNumeroMassimoDiPartecipanti());
            System.out.println("Location: " + concerto.getLocation().getNome() + ", " + concerto.getLocation().getCitta());
            System.out.println("--------------------------------------");
        }
    }

    public List<Concerto> getConcertiPerGenere(Genere genere) {
        return em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class)
                .setParameter("genere",genere)
                .getResultList();

    }
}
