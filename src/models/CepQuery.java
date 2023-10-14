package models;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepQuery {

    public AddressesCep searchCep(String userCep) {
        userCep = userCep.replaceAll("-", "");
        userCep = userCep.replaceAll(" ", "");

        String linkUrl = "https://viacep.com.br/ws/" + userCep + "/json/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(linkUrl))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), AddressesCep.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
        }
    }

    public AddressesCep searchAddresses(String uf, String city, String street) {
        city = city.replaceAll(" ", "+");
        street = street.replaceAll(" ", "+");

        String linkUrl = "https://viacep.com.br/ws/" + uf + "/" + city + "/" + street + "/json/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(linkUrl))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), AddressesCep.class);

        } catch (IOException | InterruptedException | IllegalArgumentException e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
        }
    }
}