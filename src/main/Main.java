package main;

import models.AddressesCep;
import models.CepQuery;
import models.FIleGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String userResponseContinue;
        int userResponseOption;

        Scanner scan = new Scanner(System.in);
        CepQuery cepQuery = new CepQuery();
        FIleGenerator fIleGenerator = new FIleGenerator();
        ArrayList<AddressesCep> addressesCepsList = new ArrayList<>();

        do {
            System.out.println("MENU");
            System.out.println("1. Add an address by CEP");
            System.out.println("2. Add an address by State, City and Street");
            System.out.println("3. View addresses");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            userResponseOption = scan.nextInt();

            if (userResponseOption == 1) {
                System.out.println("Enter your CEP/zip code:");
                String userCep = scan.nextLine();
                AddressesCep addressByCep = cepQuery.searchCep(userCep);
                addressesCepsList.add(addressByCep);

                System.out.println("\nAddress added in your list JSON:");

                System.out.println("CEP: " + addressByCep.cep());
                System.out.println("Street: " + addressByCep.logradouro());
                System.out.println("Neighborhood: " + addressByCep.bairro());
                System.out.println("City: " + addressByCep.localidade());
                System.out.println("State: " + addressByCep.uf());
            } else if (userResponseOption == 2) {
                System.out.println("Enter your state abbreviation (ex.: PE):");
                String uf = scan.nextLine();
                System.out.println("Enter your neighborhood name:");
                String city = scan.nextLine();
                System.out.println("Enter your street name:");
                String street = scan.nextLine();
                AddressesCep addressesByAddress = cepQuery.searchAddresses(uf, city, street);
                addressesCepsList.add(addressesByAddress);

                System.out.println("\nAddress added in your list JSON:");

                System.out.println("CEP: " + addressesByAddress.cep());
                System.out.println("Street: " + addressesByAddress.logradouro());
                System.out.println("Neighborhood: " + addressesByAddress.bairro());
                System.out.println("City: " + addressesByAddress.localidade());
                System.out.println("State: " + addressesByAddress.uf());
            }

        } while (userResponseOption != 4);

        fIleGenerator.saveFile(addressesCepsList);

    }
}
