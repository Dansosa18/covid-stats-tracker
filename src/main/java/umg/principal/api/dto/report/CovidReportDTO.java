package umg.principal.api.dto.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import umg.principal.api.dto.region.RegionDTO;

// Reporte principal
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CovidReportDTO {
    private String date;
    private int confirmed;
    private int deaths;
    private int recovered;
    @JsonProperty("confirmed_diff") private int confirmedDiff;
    @JsonProperty("deaths_diff") private int deathsDiff;
    @JsonProperty("recovered_diff") private int recoveredDiff;
    @JsonProperty("last_update") private String lastUpdate;
    private int active;
    @JsonProperty("active_diff") private int activeDiff;
    @JsonProperty("fatality_rate") private double fatalityRate;
    private RegionDTO region;
}

