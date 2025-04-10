package umg.principal.api.dto.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportResponseDTO {
    private String date;
    private int confirmed;
    private int deaths;
    private int recovered;

    @JsonProperty("region")
    private Region region;

    @Data
    public static class Region {
        private String iso;
        private String name;
        private String province;
        private double lat;
        private double lon;

        @JsonProperty("long")
        private void setLon(double longitude) {
            this.lon = longitude;
        }

        private List<City> cities;
    }

    @Data
    public static class City {
        private String name;
        private int confirmed;
        private int deaths;
    }
}