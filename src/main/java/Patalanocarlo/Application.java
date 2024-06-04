package Patalanocarlo;



import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExerciseDay2");

    public static void main(String[] args) {
     EventoDAO eventoDAO= new EventoDAO();


Evento evento1= new Evento("Comicon Italia" ,  LocalDate.now(),  "Comicon Italia Evento molto bello", 100, TipoEvento.PUBBLICO);
      eventoDAO.save(evento1);

Evento evento2= new Evento("Kings League Italia " , LocalDate.now(),  "Kings League Italia partita di calcio a 7", 500, TipoEvento.PRIVATO);
    eventoDAO.save(evento2);
   Evento TrovoElementoConId= eventoDAO.getById(evento1.getId());
        if (TrovoElementoConId != null) {
            System.out.println("Evento ottenuto: " + TrovoElementoConId.getTitolo());
        } else {
            System.out.println("Evento non trovato.");
        }


        //Elimino evento:
        eventoDAO. deleteById(evento1.getId());
        eventoDAO.close();
    }

}