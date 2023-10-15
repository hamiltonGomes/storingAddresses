package models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class CepQuery {

    public Addresses searchCep(String userCep) {
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

            return new Gson().fromJson(response.body(), Addresses.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
        }
    }

    public Addresses searchAddresses(String uf, String city, String street) {
        street = street.replaceAll(" ", "+");
        city = city.replaceAll(" ", "%20");

        String linkUrl = "https://viacep.com.br/ws/" + uf + "/" + city + "/" + street + "/json/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(linkUrl))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Type listType = new TypeToken<List<Addresses>>() {
            }.getType();
            List<Addresses> addressesList6 = new Gson().fromJson(response.body(), listType);

            if (!addressesList6.isEmpty()) {
                return addressesList6.get(0);
            } else {
                throw new RuntimeException("A lista de endereços está vazia ou o JSON não é um array válido.");
            }

        } catch (IOException | InterruptedException | IllegalArgumentException e) {
            throw new RuntimeException("Nenhum endereço encontrado para os parâmetros especificados.");
        }
    }
}
