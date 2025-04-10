package umg.principal.api.dto.city;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

// Ciudad (anidada)
@Data
public class CityDTO {
    private String name;
    private String date;
    private int fips;
    private String lat;
    @JsonProperty("long") private String longitude;
    private int confirmed;
    private int deaths;
    @JsonProperty("confirmed_diff") private int confirmedDiff;
    @JsonProperty("deaths_diff") private int deathsDiff;
    @JsonProperty("last_update") private String lastUpdate;
}
