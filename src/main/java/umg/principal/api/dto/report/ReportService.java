package umg.principal.api.dto.report;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import umg.principal.api.service.ApiHttpClient;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

public class ReportService {

    private static final Logger logger = Logger.getLogger(ReportService.class.getName());
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public ReportService() {
        this.emf = Persistence.createEntityManagerFactory("COVID");
        this.em = emf.createEntityManager();
    }

    public void fetchAndSaveReports(String iso, String dateStr) {
        try {
            logger.info("Fetching report for ISO: " + iso + " and date: " + dateStr);

            // Convert the date string to LocalDate
            LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_DATE);

            // Fetch the reports from the API
            List<Report> reports = ApiHttpClient.getReports(iso, dateStr);

            if (reports != null && !reports.isEmpty()) {
                for (Report report : reports) {
                    // Set the LocalDate in the Report object
                    report.setFecha(date);
                    logger.info("Report fetched successfully: " + report);

                    // Save each report to the database
                    saveReport(report);
                }
            } else {
                logger.warning("Could not fetch valid reports for ISO: " + iso + " and date: " + dateStr);
            }

        } catch (IOException e) {
            logger.severe("Error fetching reports from the API: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            logger.severe("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void saveReport(Report report) {
        try {
            em.getTransaction().begin();
            em.persist(report);
            em.getTransaction().commit();
            logger.info("✅ Report saved successfully: " + report);
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            logger.severe("❌ Error saving the report: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
        logger.info("Connections closed successfully");
    }
}