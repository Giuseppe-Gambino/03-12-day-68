package it.epicode;


import com.github.javafaker.Faker;
import it.epicode.eventi.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("util-jpa");

        Faker faker = new Faker(new Locale("it"));

        EntityManager em = emf.createEntityManager();



            EventoDAO eventoDAO = new EventoDAO(em);
            LocationDAO locationDAO = new LocationDAO(em);
            PersonaDAO personaDAO = new PersonaDAO(em);
            PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
        try {


            Location location = new Location();
            location.setCitta("Ravanusa");
            location.setNome("piazza minghetti");

            locationDAO.insertLocation(location);


            Evento evento = new Evento();
            evento.setTitolo("Trimone");
            evento.setDataEvento("2022-12-03");
            evento.setDescrizione("Siuumm");
            evento.setTipoEvento("Conferenza bona");
            evento.setNumeroMassimoDiPartecipanti(175);
            evento.setLocation(location);

            eventoDAO.insertEvento(evento);

            Persona persona = new Persona();
            persona.setNome("pino");
            persona.setCognome("trm");
            persona.setEmail("utrimao@gmail.com");
            persona.setSesso("m");
            persona.setDataDiNascita(LocalDate.of(2003,3,18));

            personaDAO.insertPersona(persona);

            Partecipazione partecipazione = new Partecipazione();
            partecipazione.setEvento(evento);
            partecipazione.setPersona(persona);
            partecipazione.setStato(Partecipazione.StatoPartecipazione.CONFERMATA);

            partecipazioneDAO.insertPartecipazione(partecipazione);

            em.getTransaction().begin();
            persona.setPartecipazioni(partecipazione);
            em.persist(persona);
            em.getTransaction().commit();



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }


    }
}