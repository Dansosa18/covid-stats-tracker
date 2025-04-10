package umg.principal.api.dto.region;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import umg.principal.api.dto.city.CityDTO;

import java.util.List;

// Región (anidada)
@Data
public class RegionDTO {
    private String iso;
    private String name;
    private String province;
    private String lat;
    @JsonProperty("long") private String longitude;
    private List<CityDTO> cities;
}
