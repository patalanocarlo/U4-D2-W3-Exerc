package Patalanocarlo;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "evento")
@Inheritance(strategy = InheritanceType.JOINED)
public class Evento {

    @Id
    @GeneratedValue
    private Long id;

    private String titolo;

    @Column(name = "data_evento")
    private LocalDate dataEvento;

    @Column
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento")
    private TipoEvento tipoEvento;

    @Column(name = "numero_massimo_partecipanti")
    private int numeroMassimoPartecipanti;
//CASCADETYPE LO HO USATO PER ANDARE AD USARE IL SALVATAGGIO E LA ELIMINAZIONE AD OGNI ISTANZA DELLE PARTECIPèAZIONI cioè se elimino un evento eliminero anche la sua partecipazione.
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL) //Vado a dire che un singolo evento puo avere piu Partecipazioni
    private List<Partecipazione> listaPartecipazioni; //appunto può avere varie partecipazioni di una Lista

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
//Dato che molti eventi Possono essere assocaiti a un unica Location ho creato un ManytoONE cosi facendo ho una location ma con piu eventi
    //Inoltre vado a dire che la colonna del id della località del evento verra associato ad ogni singolo evento per quella località
    public Evento() {}

    public Evento(String titolo, LocalDate dataEvento, String descrizione, int numeroMassimoPartecipanti, TipoEvento tipoEvento, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;
    }



    // Getters e Setters
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
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
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

    public List<Partecipazione> getListaPartecipazioni() {
        return listaPartecipazioni;
    }

    public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
        this.listaPartecipazioni = listaPartecipazioni;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}