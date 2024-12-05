package it.epicode.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Data
@Entity
@NamedQuery(name = "Trova_tutto_PartitaDiCalcio", query = "SELECT a FROM PartitaDiCalcio a")
@NamedQuery(name = "partite_vinte_in_casa", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraDiCasa = p.squadraVincente ")
@NamedQuery(name = "partite_vinte_in_trasferta", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraOspite = p.squadraVincente ")

@DiscriminatorValue("partita_di_calcio")
public class PartitaDiCalcio extends Evento {

    @Column(name = "squadra_di_casa")
    private String squadraDiCasa;

    @Column(name = "squadra_ospite")
    private String squadraOspite;

    @Column(name = "squadra_vincente")
    private String squadraVincente;

    @Column(name = "numero_di_gol_squadra_di_casa")
    private Integer numeroDiGolSquadraDiCasa;

    @Column(name = "numero_di_gol_squadra_ospite")
    private Integer numeroDiGolSquadraOspite;

}
