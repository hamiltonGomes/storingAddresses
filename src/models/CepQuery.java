package models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepQuery {

    public Addresses searchCep(String userCep) {
        try {
            String linkUrl = "https://viacep.com.br/ws/" + userCep + "/json/";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(linkUrl))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();

            return gson.fromJson(response.body(), Addresses.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
        }
    }
}
