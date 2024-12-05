package it.epicode.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@NamedQuery(name = "Trova_tutto_GaraDiAtletica", query = "SELECT a FROM GaraDiAtletica a")
@DiscriminatorValue("gara_atletica")
public class GaraDiAtletica extends Evento {

    @OneToMany
    private Set<Persona> atleti;

    @OneToOne
    @JoinColumn(name = "vincitore")
    private Persona vincitore;

}