package umg.principal.api.dto.report;

import java.util.List;

public class CovidReportWrapperDTO {
    private List<CovidReportDTO> data;

    public List<CovidReportDTO> getData() {
        return data;
    }

    public void setData(List<CovidReportDTO> data) {
        this.data = data;
    }
}
