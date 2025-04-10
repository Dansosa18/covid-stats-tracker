package umg.principal.api.dto.province;

import lombok.Data;

import java.util.List;

@Data
public class ProvinceApiResponseWrapper {
    private List<ProvinceResponseDTO> data;

}