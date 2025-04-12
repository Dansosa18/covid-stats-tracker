package umg.principal.api.dto.report;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ReportDao {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("COVID");

    public void saveReport(Report report) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(report);
            em.getTransaction().commit();
            System.out.println("✅ Report saved successfully: " + report);
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("❌ Error saving the report: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }
}