package main;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Addresses;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String userResponse;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Enter your CEP/zip code:");
            String userCEP = scan.nextLine();
            userCEP = userCEP.replaceAll("-", "");
            userCEP = userCEP.replaceAll(" ", "");

            try {
                String linkUrl = "https://viacep.com.br/ws/" + userCEP + "/json/";
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(linkUrl))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

//                System.out.println(response.body());

                Gson gson = new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                        .create();

                Addresses addresses = gson.fromJson(response.body(), Addresses.class);

                System.out.println(addresses);


            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Do you want to continue? (Yes/No)");
            userResponse = scan.nextLine();

        } while (userResponse.toLowerCase().charAt(0) != 'n');


    }
}
