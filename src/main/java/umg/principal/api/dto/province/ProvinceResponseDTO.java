package umg.principal.api.dto.province;

import lombok.Data;
import umg.principal.api.dto.city.CityResponseDTO;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProvinceResponseDTO {
    private String iso;
    private String province;
    private List<CityResponseDTO> cities = new ArrayList<>();
}