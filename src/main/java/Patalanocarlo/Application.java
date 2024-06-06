package Patalanocarlo;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Esercitazione-d5-w3");

    public static void main(String[] args) {
        EventoDAO eventoDAO = new EventoDAO();
        PersonaDAO personaDAO = new PersonaDAO();
        LocationDAO locationDAO = new LocationDAO();
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();

        Location location = new Location("Stadio San Siro", "Milano");
        locationDAO.save(location);
        Location location1=new Location("Stadio Diego Armando Maradona" , "Napoli");
        locationDAO.save(location1);
        Persona persona = new Persona("Carlo", "Patalano", "patalanocarlo674@gmail.com", LocalDate.of(2003, 4, 1), Sesso.MASCHIO);
        personaDAO.save(persona);

        Evento evento = new Evento("Partita di Calcio", LocalDate.now(), "Derby tra Inter e Milan", 100000, TipoEvento.PUBBLICO, location);
        eventoDAO.save(evento);

        Partecipazione partecipazione = new Partecipazione(persona, evento, Stato.CONFERMATO);
        partecipazioneDAO.save(partecipazione);

        // Recupera e stampa l'evento salvato
        Evento retrievedEvento = eventoDAO.getById(evento.getId());
        if (retrievedEvento != null) {
            System.out.println("Evento ottenuto: " + retrievedEvento.getTitolo());
        } else {
            System.out.println("Evento non trovato.");
        }
Persona trovapersona=personaDAO.getById(persona.getId());
        if (trovapersona!= null){
            System.out.println("Ecco la persona che hai trovato:" + trovapersona.getNome());
        }else {
            System.out.println("Persona non trovata.");
        }
        // Elimina l'evento
        eventoDAO.deleteById(2052L);
        personaDAO.deleteById(902L);
        PartitaDiCalcio partitaDiCalcio = new PartitaDiCalcio("Inter vs Milan", LocalDate.now(), "Derby tra Inter e Milan", 100000, TipoEvento.PUBBLICO, location, "Inter", "Milan", "Inter", 1, 0);
        eventoDAO.save(partitaDiCalcio);

        // Creazione e salvataggio di un nuovo concerto
        Concerto concerto = new Concerto("Concerto di Rock", LocalDate.of(2024, 6, 10), "Concerto di musica rock", 5000, TipoEvento.PUBBLICO, location, Genere.ROCK, true);
        eventoDAO.save(concerto);

    }

}