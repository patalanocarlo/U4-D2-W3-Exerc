package Patalanocarlo;

import jakarta.persistence.*;

public class PartecipazioneDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public PartecipazioneDAO() {
        this.emf = Persistence.createEntityManagerFactory("ExerciseDay2");
        this.em = emf.createEntityManager();
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(partecipazione);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Partecipazione getById(Long id) {
        try {
            return em.find(Partecipazione.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteById(Long id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Partecipazione partecipazione = em.find(Partecipazione.class, id);
            if (partecipazione != null) {
                em.remove(partecipazione);
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