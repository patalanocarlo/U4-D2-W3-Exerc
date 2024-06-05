package Patalanocarlo;

import jakarta.persistence.*;

public class PersonaDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public PersonaDAO() {
        this.emf = Persistence.createEntityManagerFactory("ExerciseDay2");
        this.em = emf.createEntityManager();
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(persona);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Persona getById(Long id) {
        try {
            return em.find(Persona.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteById(Long id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Persona persona = em.find(Persona.class, id);
            if (persona != null) {
                em.remove(persona);
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