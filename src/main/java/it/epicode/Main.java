package it.epicode;


import com.github.javafaker.Faker;
import it.epicode.eventi.Evento;
import it.epicode.eventi.EventoDAO;
import it.epicode.eventi.Location;
import it.epicode.eventi.LocationDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("util-jpa");

        Faker faker = new Faker(new Locale("it"));

        EntityManager em = emf.createEntityManager();



            EventoDAO eventoDAO = new EventoDAO(em);
            LocationDAO locationDAO = new LocationDAO(em);
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

            System.out.println(eventoDAO.getById(1L));
//            eventoDAO.delete(1L);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }


    }
}