package umg.principal.api.service;

import umg.principal.api.dto.province.Province;
import umg.principal.api.dto.region.Region;
import umg.principal.api.dto.report.Report;
import umg.principal.api.dto.report.ReportService;

import java.util.List;

public class CovidApiService {

    public void processCovidData() {
        try {
            List<String> regions = ApiHttpClient.getRegions();
            System.out.println("[INFO] Regions fetched: " + regions.size());

            List<String> provinces = ApiHttpClient.getProvinces("GTM");
            System.out.println("[INFO] Provinces fetched: " + provinces.size());

            Report report = ApiHttpClient.getReport("GTM", "2022-04-16");
            System.out.println("[INFO] Report fetched for GTM");

            // Instancia de ReportService
            ReportService reportService = new ReportService();

            // Llamada al método guardarReporte con la instancia correcta
            reportService.guardarReporte(report);

            // Cierre de conexiones
            reportService.cerrarConexion();

        } catch (Exception e) {
            System.err.println("[ERROR] " + e.getMessage());
            e.printStackTrace();
        }
    }
}