package Patalanocarlo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;


@Entity
@DiscriminatorValue("GARA_ATLETICA")
public class GaraDiAtletica extends Evento {

    @ManyToMany
    @JoinTable(
            name = "evento_atleta",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id")
    )
    private Set<Persona> atleti;

    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;

    public GaraDiAtletica() {
        super();
    }

    // Costruttore con tutti gli argomenti
    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, int numeroMassimoPartecipanti, TipoEvento tipoEvento, Location location, Set<Persona> atleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, numeroMassimoPartecipanti, tipoEvento, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    // Getters e Setters
    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}