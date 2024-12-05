package it.epicode.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
@Entity
@NamedQuery(name = "Trova_tutto_Concerto", query = "SELECT a FROM Concerto a")
@DiscriminatorValue("concerto")
public class Concerto extends Evento {

    @Column(name = "in_streaming")
    private Boolean inStreaming;

    @Enumerated
    @Column(name = "genere")
    private Genere genere;

}
