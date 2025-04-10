package umg.principal.api.dto.city;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityResponseDTO {
    private String name;
    private String date;
    private int confirmed;
    private int deaths;
    private double lat;
    private double lon;
}