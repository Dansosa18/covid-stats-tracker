import umg.principal.api.service.CovidApiService;
import umg.principal.api.dto.region.RegionResponseDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ApiConsumerTest {
    @Test
    public void testFetchRegions() {
        CovidApiService service = new CovidApiService();
        List<RegionResponseDTO> regions = service.fetchRegions();
        System.out.println("Regions obtained: " + regions.size());
    }

//    @Test
//    public void testRegionData() {
//        List<RegionResponseDTO> regions = CovidApiService.fetchRegions();
//        regions.forEach(region ->
//                System.out.println("ISO: " + region.getIso() + " | Nombre: " + region.getName())
//        );
//    }

//    @Test
//    public void testFetchProvinces() {
//        CovidApiService service = new CovidApiService();
//        List<ProvinceResponseDTO> provinces = service.fetchProvincesByRegion("GtM");
//        provinces.forEach(p -> System.out.println("Provincia: " + p.getProvince()));
//    }

}