package vicktorms.br.infnet.service;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import vicktorms.br.infnet.model.Address;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class AddressService {

    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);
    private final String VIACEP_BASE_URL = "https://viacep.com.br/ws/";

    public Address getAddressByCep(String cep) throws IOException {
        String jsonCep = fetchJsonFromUrl( VIACEP_BASE_URL + cep + "/json/");
        return convertJsonToObject(jsonCep, Address.class);
    }

    private String fetchJsonFromUrl(String urlString) throws IOException {
        HttpURLConnection connection = openConnection(urlString);

        try (InputStream inputStream = connection.getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
            String jsonCep = readJsonFromStream(bufferedReader);

            // Logando Status Code e Resposta JSON
            logger.info("JSON Response: {}", jsonCep);
            logger.info("Status Code: {}", connection.getResponseCode());

            return jsonCep;
        }
    }

    private HttpURLConnection openConnection(String urlString) throws IOException {
        URL url = new URL(urlString);
        return (HttpURLConnection) url.openConnection();
    }

    private String readJsonFromStream(BufferedReader bufferedReader) throws IOException {
        StringBuilder jsonCep = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            jsonCep.append(line);
        }
        return jsonCep.toString();
    }

    private <T> T convertJsonToObject(String jsonString, Class<T> targetType) {
        return new Gson().fromJson(jsonString, targetType);
    }
}
