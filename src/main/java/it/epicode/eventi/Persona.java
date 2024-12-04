package it.epicode.eventi;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Persona")
@Data
@NoArgsConstructor
public class Persona {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "data_nascita", nullable = false)
    private LocalDate dataDiNascita;

    @Column(nullable = false, length = 1)
    private String sesso; // 'M' o 'F'

    @OneToOne
    @JoinColumn(name = "partecipazione")
    private Partecipazione Partecipazioni;
}
