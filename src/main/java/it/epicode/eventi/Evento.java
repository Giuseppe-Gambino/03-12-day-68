package it.epicode.eventi;

import jakarta.persistence.*;



@Entity
@Table(name="evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    // , unique = true
    @Column(name = "titolo", nullable = false , length = 50)
    private String titolo;

    @Column(name = "data_evento", nullable = false)
    private String dataEvento;

    @Column(name = "descrizione", nullable = false, length = 100)
    private String descrizione;

    @Column(name = "tipo_evento",  nullable = false)
    private String tipoEvento;

    @Column(name = "numero_massimo_di_partecipanti")
    private Integer numeroMassimoDiPartecipanti;

    @OneToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Integer getNumeroMassimoDiPartecipanti() {
        return numeroMassimoDiPartecipanti;
    }

    public void setNumeroMassimoDiPartecipanti(Integer numeroMassimoDiPartecipanti) {
        this.numeroMassimoDiPartecipanti = numeroMassimoDiPartecipanti;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
