package Patalanocarlo;

import jakarta.persistence.*;

public class EventoDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public EventoDAO() {
        this.emf = Persistence.createEntityManagerFactory("ExerciseDay2");
        this.em = emf.createEntityManager();
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(evento);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Evento getById(Long id) {
        try {
            return em.find(Evento.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteById(Long id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            Evento evento = em.find(Evento.class, id);
            if (evento != null) {
                em.remove(evento);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}