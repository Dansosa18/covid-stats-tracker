import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import umg.principal.api.dto.report.CovidReportDTO;
import umg.principal.api.service.CovidApiService;
import java.util.List;

public class CovidReportsTest {
    public static void main(String[] args) {
        CovidReportsTest test = new CovidReportsTest();
        test.printFullReportExample();
    }
    public void printFullReportExample() {
        CovidApiService covidApiService = new CovidApiService();
        List<CovidReportDTO> reports = covidApiService.fetchFullReports("CHN", "2020-04-01");

        // Convertir a JSON bonito (usando Jackson)
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        reports.forEach(report -> {
            try {
                String json = mapper.writeValueAsString(report);
                System.out.println(json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
    }
}