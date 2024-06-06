package Patalanocarlo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.hibernate.annotations.NamedQuery;

import java.time.LocalDate;


@Entity
@DiscriminatorValue("PARTITA_CALCIO")

@NamedQuery(name = "PartitaDiCalcio.getPartiteVinteInCasa", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraCasa")
@NamedQuery(name = "PartitaDiCalcio.getPartiteVinteInTrasferta", query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente != p.squadraCasa")
public class PartitaDiCalcio extends Evento {

    @Column(name = "squadra_casa")
    private String squadraCasa;

    @Column(name = "squadra_ospite")
    private String squadraOspite;

    @Column(name = "squadra_vincente")
    private String squadraVincente;

    @Column(name = "numero_gol_casa")
    private int numeroGolCasa;

    @Column(name = "numero_gol_ospite")
    private int numeroGolOspite;

    public PartitaDiCalcio() {
        super();
    }


    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, int numeroMassimoPartecipanti, TipoEvento tipoEvento, Location location, String squadraCasa, String squadraOspite, String squadraVincente, int numeroGolCasa, int numeroGolOspite) {
        super(titolo, dataEvento, descrizione, numeroMassimoPartecipanti, tipoEvento, location);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.numeroGolCasa = numeroGolCasa;
        this.numeroGolOspite = numeroGolOspite;
    }

    // Getters e Setters
    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getNumeroGolCasa() {
        return numeroGolCasa;
    }

    public void setNumeroGolCasa(int numeroGolCasa) {
        this.numeroGolCasa = numeroGolCasa;
    }

    public int getNumeroGolOspite() {
        return numeroGolOspite;
    }

    public void setNumeroGolOspite(int numeroGolOspite) {
        this.numeroGolOspite = numeroGolOspite;
    }
}