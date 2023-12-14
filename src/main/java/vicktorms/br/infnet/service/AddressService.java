package vicktorms.br.infnet.service;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import vicktorms.br.infnet.model.Address;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class AddressService {

    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);
    private static final String VIACEP_BASE_URL = "https://viacep.com.br/ws/";

    public Address getAddressByCep(String cep) throws IOException, InterruptedException {
        String jsonCep = fetchJsonFromUrl(VIACEP_BASE_URL + cep + "/json/");
        return convertJsonToObject(jsonCep, Address.class);
    }

    private String fetchJsonFromUrl(String urlString) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        String jsonCep = response.body();

        // Logando Status Code e Resposta JSON
        logger.info("JSON Response: {}", jsonCep);
        logger.info("Status Code: {}", response.statusCode());

        return jsonCep;
    }

    private <T> T convertJsonToObject(String jsonString, Class<T> targetType) {
        return new Gson().fromJson(jsonString, targetType);
    }
}
