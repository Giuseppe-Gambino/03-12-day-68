package it.epicode.eventi;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "partecipazione")
@Data
@NoArgsConstructor
public class Partecipazione {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatoPartecipazione stato; // ENUM con i valori "CONFERMATA" e "DA_CONFERMARE"


    public enum StatoPartecipazione {
        CONFERMATA,
        DA_CONFERMARE
    }

}
