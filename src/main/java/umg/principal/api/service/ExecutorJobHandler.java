package umg.principal.api.service;

import umg.principal.api.dto.report.ReportService;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

public class ExecutorJobHandler {

    private static final Logger logger = Logger.getLogger(ExecutorJobHandler.class.getName());

    public void startProcessing(int waitSeconds) {
        logger.info("Scheduling API consumption to run in " + waitSeconds + " segundos");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                procesAPIData();
                timer.cancel(); // Stop the timer after the first execution
            }
        }, waitSeconds* 1000); // Convert seconds to milliseconds
    }

    private void procesAPIData() {
        logger.info("Starting the API consumption process");

        // Fetch regions
        ApiHttpClient.getRegions();
        logger.info("Fetched " + ApiHttpClient.getRegions().size() + " regions");

        // Fetch provinces for Guatemala (ISO: GTM)
        ApiHttpClient.getProvinces("GTM");
        logger.info("Fetched " + ApiHttpClient.getProvinces("GTM").size() + " provinces for ISO: GTM");

        // Fetch report for Guatemala (ISO: GTM) and date 2022-04-16
        String iso = "GTM";
        String date = "2022-04-16";

        ReportService reportService = new ReportService();
        reportService.fetchAndSaveReports(iso, date);
        reportService.closeConnection();

        logger.info("Proceso de consumo de API completado exitosamente");
    }
}