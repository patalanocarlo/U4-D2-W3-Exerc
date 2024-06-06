package Patalanocarlo;

import jakarta.persistence.*;

public class LocationDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public LocationDAO() {
        this.emf = Persistence.createEntityManagerFactory("Esercitazione-d5-w3");
        this.em = emf.createEntityManager();
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(location);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Location getById(Long id) {
        try {
            return em.find(Location.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteById(Long id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Location location = em.find(Location.class, id);
            if (location != null) {
                em.remove(location);
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