package it.epicode;


import com.github.javafaker.Faker;
import it.epicode.dao.*;
import it.epicode.entity.*;
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


        ConcertoDAO concertoDAO = new ConcertoDAO(em);
            LocationDAO locationDAO = new LocationDAO(em);
            EventoDAO eventoDAO = new EventoDAO(em);

            PersonaDAO personaDAO = new PersonaDAO(em);
            PartitaDiCalcioDAO partitaDiCalcioDAO = new PartitaDiCalcioDAO(em);

        try {


            Location location = new Location();
            location.setCitta("Napoli");
            location.setNome("piazza minghetti");

            locationDAO.insertLocation(location);


            for (int i = 0; i < 10; i++) {


                Concerto concerto = new Concerto();
                concerto.setTitolo(faker.esports().league());
                concerto.setDataEvento("2022-12-03");
                concerto.setDescrizione(faker.demographic().race());
                concerto.setTipoEvento(faker.artist().name());
                concerto.setNumeroMassimoDiPartecipanti(faker.number().randomDigit());
                concerto.setLocation(location);
                concerto.setGenere(Genere.POP);
                concerto.setInStreaming(faker.bool().bool());


                concertoDAO.save(concerto);

                Persona persona = new Persona();
                persona.setNome(faker.name().name());
                persona.setCognome(faker.name().lastName());
                persona.setEmail(faker.internet().emailAddress());
                persona.setSesso("m");
                persona.setDataDiNascita(LocalDate.of(2003,3,18));


                personaDAO.insertPersona(persona);


                String squad1 = faker.name().name();
                String squad2 = faker.name().name();


                PartitaDiCalcio partitaDiCalcio = new PartitaDiCalcio();
                partitaDiCalcio.setSquadraDiCasa(squad1);
                partitaDiCalcio.setSquadraOspite(squad2);
                partitaDiCalcio.setSquadraVincente(squad1);
                partitaDiCalcio.setNumeroDiGolSquadraDiCasa(faker.number().randomDigit());
                partitaDiCalcio.setNumeroDiGolSquadraOspite(faker.number().randomDigit());
                partitaDiCalcio.setTitolo(faker.esports().event());
                partitaDiCalcio.setDataEvento("2022-12-03");
                partitaDiCalcio.setDescrizione(faker.demographic().race());
                partitaDiCalcio.setTipoEvento(faker.artist().name());
                partitaDiCalcio.setNumeroMassimoDiPartecipanti(faker.number().randomDigit());
                partitaDiCalcio.setLocation(location);

                partitaDiCalcioDAO.save(partitaDiCalcio);

            }

            System.out.println(partitaDiCalcioDAO.getPartiteVinteInCasa());
            System.out.println(partitaDiCalcioDAO.getPartiteVinteInTrasferta());

//            eventoDAO.stampConcertiInStreaming(true);
            System.out.println(eventoDAO.getConcertiPerGenere(Genere.POP));



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }


    }
}