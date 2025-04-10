import umg.principal.api.dto.province.ProvinceResponseDTO;
import umg.principal.api.service.CovidApiService;

import java.util.List;

    public class ProvinceCitiesPrinter {
        public static void main(String[] args) {
            CovidApiService apiService = new CovidApiService();  // Instancia manual (si no usas Spring)
            // O usa @Autowired si es un proyecto Spring Boot

            System.out.println("=== Datos de Provincias y Ciudades ===");
            List<ProvinceResponseDTO> provinces = apiService.fetchProvincesWithCities("USA");

            provinces.forEach(province -> {
                System.out.println("\nProvincia: " + province.getProvince());
                System.out.println("Ciudades:");

                province.getCities().forEach(city -> {
                    System.out.println(
                            "  - " + city.getName() +
                                    " | Confirmados: " + city.getConfirmed() +
                                    " | Fecha: " + city.getDate()
                    );
                });
            });
        }
    }