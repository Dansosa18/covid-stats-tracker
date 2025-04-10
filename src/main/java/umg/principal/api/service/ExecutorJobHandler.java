package umg.principal.api.service;

import umg.principal.api.dto.report.ReportService;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

public class ExecutorJobHandler {

    private static final Logger logger = Logger.getLogger(ExecutorJobHandler.class.getName());

    public void iniciarProcesamiento(int segundosEspera) {
        logger.info("Programando el consumo de la API para ejecutarse en " + segundosEspera + " segundos");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                procesarDatosAPI();
                timer.cancel(); // Detener el timer después de la primera ejecución
            }
        }, segundosEspera * 1000); // Convertir segundos a milisegundos
    }

    private void procesarDatosAPI() {
        logger.info("Iniciando el proceso de consumo de la API");

        // Obtener regiones
        ApiHttpClient.getRegions();
        logger.info("Se obtuvieron " + ApiHttpClient.getRegions().size() + " regiones");

        // Obtener provincias para Guatemala (ISO: GTM)
        ApiHttpClient.getProvinces("GTM");
        logger.info("Se obtuvieron " + ApiHttpClient.getProvinces("GTM").size() + " provincias para ISO: GTM");

        // Obtener reporte para Guatemala (ISO: GTM) y fecha 2022-04-16
        String iso = "GTM";
        String date = "2022-04-16";

        ReportService reportService = new ReportService();
        reportService.obtenerYGuardarReporte(iso, date);
        reportService.cerrarConexion();

        logger.info("Proceso de consumo de API completado exitosamente");
    }
}