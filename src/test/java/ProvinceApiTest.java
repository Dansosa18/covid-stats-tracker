import umg.principal.api.dto.province.ProvinceResponseDTO;
import umg.principal.api.service.CovidApiService;

import java.util.List;

public class ProvinceApiTest {
    public static void main(String[] args) {
        CovidApiService service = new CovidApiService();
        List<ProvinceResponseDTO> provinces = service.fetchProvinces("CHN"); // ISO de Guatemala
        provinces.forEach(p -> System.out.println(p.getProvince() + " | ISO: " + p.getIso()));    }
}