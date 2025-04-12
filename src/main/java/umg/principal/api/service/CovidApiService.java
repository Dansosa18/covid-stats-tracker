package umg.principal.api.service;

import umg.principal.api.dto.report.Report;
import umg.principal.api.dto.report.ReportService;

import java.util.List;

public class CovidApiService {

    public void processCovidData() {
        try {
            // Fetch regions and provinces
            List<String> regions = ApiHttpClient.getRegions();
            System.out.println("[INFO] Regions fetched: " + regions.size());

            List<String> provinces = ApiHttpClient.getProvinces("GTM");
            System.out.println("[INFO] Provinces fetched: " + provinces.size());

            // Fetch reports for all provinces
            List<Report> reports = ApiHttpClient.getReports("GTM", "2022-04-16");
            System.out.println("[INFO] Reports fetched for GTM");

            // Instance of ReportService
            ReportService reportService = new ReportService();

            // Iterate over the list of reports and save each one
            for (Report report : reports) {
                // Save the report in the database
                reportService.saveReport(report);
            }

            // Close connections
            reportService.closeConnection();

        } catch (Exception e) {
            System.err.println("[ERROR] " + e.getMessage());
            e.printStackTrace();
        }
    }
}