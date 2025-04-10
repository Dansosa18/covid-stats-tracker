package umg.principal.api.dto.region;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RegionResponseWrapperDTO {
    @JsonProperty("data")
    private List<RegionResponseDTO> data;
}