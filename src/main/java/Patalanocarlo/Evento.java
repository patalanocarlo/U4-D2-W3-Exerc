package Patalanocarlo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

private String titolo;

@Column(name = "data_Evento")
    private LocalDate DataEvento;

@Column
    private String descrizione;
@Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento")
    private TipoEvento tipoEvento;

    @Column(name = "numero_massimo_partecipanti")
    private int numeroMassimoPartecipanti;


    public Evento(){

    }

    public Evento(String titolo,LocalDate dataEvento,String descrizione ,int numeroMassimoPartecipanti,TipoEvento tipoEvento){
        this.titolo=titolo;
        this.DataEvento=dataEvento;
        this.descrizione=descrizione;
        this.tipoEvento=tipoEvento;
        this.numeroMassimoPartecipanti=numeroMassimoPartecipanti;

    }
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

    public LocalDate getDataEvento() {
        return DataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.DataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }
}

