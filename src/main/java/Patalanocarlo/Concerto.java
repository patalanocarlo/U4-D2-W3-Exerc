package Patalanocarlo;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@DiscriminatorValue("CONCERTO")
public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    private Genere genere;

    @Column(name = "in_streaming")
    private boolean inStreaming;

    public Concerto() {
        super();
    }

    // Costruttore con tutti gli argomenti
    public Concerto(String titolo, LocalDate dataEvento, String descrizione, int numeroMassimoPartecipanti, TipoEvento tipoEvento, Location location, Genere genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, numeroMassimoPartecipanti, tipoEvento, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    // Getters e Setters
    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}