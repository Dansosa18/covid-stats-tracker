package umg.principal.api.dto.report;
import java.util.List;
import lombok.Data;


@Data
public class ReportApiResponseWrapper {
    private List<ReportResponseDTO> data;
}