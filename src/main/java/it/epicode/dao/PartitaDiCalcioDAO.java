package it.epicode.dao;

import it.epicode.entity.PartitaDiCalcio;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PartitaDiCalcioDAO {
    private EntityManager em;

    public void save(PartitaDiCalcio oggetto) {
        em.getTransaction().begin();
        em.persist(oggetto);
        em.getTransaction().commit();
    }

    public PartitaDiCalcio findById(Long id) {
        return em.find(PartitaDiCalcio.class, id);
    }

    public List<PartitaDiCalcio> findAll() {
        return em.createNamedQuery("Trova_tutto_PartitaDiCalcio", PartitaDiCalcio.class).getResultList();
    }

    public void update(PartitaDiCalcio oggetto) {
        em.getTransaction().begin();
        em.merge(oggetto);
        em.getTransaction().commit();
    }

    public void delete(PartitaDiCalcio oggetto) {
        em.getTransaction().begin();
        em.remove(oggetto);
        em.getTransaction().commit();
    }


    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        return em.createNamedQuery("partite_vinte_in_casa", PartitaDiCalcio.class)
                .getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        return em.createNamedQuery("partite_vinte_in_trasferta", PartitaDiCalcio.class)
                .getResultList();
    }

}
