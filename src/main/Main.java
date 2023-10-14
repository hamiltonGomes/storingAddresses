package main;

import models.Addresses;
import models.CepQuery;
import models.FIleGenerator;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String userResponse;
        Scanner scan = new Scanner(System.in);
        CepQuery cepQuery = new CepQuery();
        FIleGenerator fIleGenerator = new FIleGenerator();
        Addresses address = new Addresses();

        do {
            System.out.println("Enter your CEP/zip code:");
            String userCep = scan.nextLine();
            userCep = userCep.replaceAll("-", "");
            userCep = userCep.replaceAll(" ", "");
            System.out.println(cepQuery.searchCep(userCep));

            address.addAddresses(cepQuery.searchCep(userCep));

            System.out.println("\nDo you want to continue? (Yes/No)");
            userResponse = scan.nextLine();

        } while (userResponse.toLowerCase().charAt(0) != 'n');

        fIleGenerator.saveFile(address.getAddresses());
    }
}
