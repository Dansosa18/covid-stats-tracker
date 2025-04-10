package umg.principal.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import umg.principal.api.dto.province.ProvinceApiResponseWrapper;
import umg.principal.api.dto.province.ProvinceResponseDTO;
import umg.principal.api.dto.region.RegionResponseDTO;
import umg.principal.api.dto.region.RegionResponseWrapperDTO;
import umg.principal.api.dto.report.CovidReportDTO;
import umg.principal.api.dto.report.CovidReportWrapperDTO;

import java.util.List;

@Service
public class CovidApiService {
    private static final Logger log = LoggerFactory.getLogger(CovidApiService.class);
    private static final String API_URL = "https://covid-19-statistics.p.rapidapi.com";
    private static final String API_KEY = "15baf0fbd6mshe75d2ec3cfe7e1fp14e9dbjsn06c86af3826c";

    public static List<RegionResponseDTO> fetchRegions() {
        RegionResponseWrapperDTO response = WebClient.builder()
                .baseUrl(API_URL)
                .defaultHeader("X-RapidAPI-Key", API_KEY)
                .defaultHeader("X-RapidAPI-Host", "covid-19-statistics.p.rapidapi.com")
                .build()
                .get()
                .uri("/regions")
                .retrieve()
                .bodyToMono(RegionResponseWrapperDTO.class)
                .block();

        return response.getData();
    }

    public List<ProvinceResponseDTO> fetchProvinces(String regionIso) {  // Ej: "GTM"
        String url = API_URL + "/provinces?iso=" + regionIso;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", API_KEY);
        headers.set("X-RapidAPI-Host", "covid-19-statistics.p.rapidapi.com");
        headers.set("Content-Type", "application/json");


        String requestBody = "{\"iso\": \"" + regionIso + "\"}";
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProvinceApiResponseWrapper> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                ProvinceApiResponseWrapper.class
        );

        return response.getBody().getData();
    }

    public List<ProvinceResponseDTO> fetchProvincesWithCities(String regionIso) {
        String url = API_URL + "/provinces?iso=" + regionIso;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", API_KEY);
        headers.set("X-RapidAPI-Host", "covid-19-statistics.p.rapidapi.com");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProvinceApiResponseWrapper> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                ProvinceApiResponseWrapper.class
        );

        return response.getBody().getData();
    }
    public List<CovidReportDTO> fetchFullReports(String iso, String date) {
        String url = String.format("%s/reports?iso=%s&date=%s", API_URL, iso, date);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", API_KEY);
        headers.set("X-RapidAPI-Host", "covid-19-statistics.p.rapidapi.com");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CovidReportWrapperDTO> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                CovidReportWrapperDTO.class
        );

        return response.getBody().getData();
    }
}