import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;

public class ApiResponsePrinter {
    public static void main(String[] args) {
        String API_URL = "https://covid-19-statistics.p.rapidapi.com";
        String API_KEY = "15baf0fbd6mshe75d2ec3cfe7e1fp14e9dbjsn06c86af3826c";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", API_KEY);
        headers.set("X-RapidAPI-Host", "covid-19-statistics.p.rapidapi.com");

        String response = restTemplate.exchange(
                API_URL + "/regions",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class
        ).getBody();

        System.out.println("API response obtained:\n" + response);
    }
}