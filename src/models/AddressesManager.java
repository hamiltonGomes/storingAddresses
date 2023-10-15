package models;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressesManager {

    private final ArrayList<Addresses> addressesArrayList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public void addAddressesByCep(CepQuery cepQuery) {
        System.out.println("Enter your CEP/zip code:");
        String userCep = scan.nextLine();

        Addresses addressByCep = cepQuery.searchCep(userCep);
        addressesArrayList.add(addressByCep);
        System.out.println("Address added successfully!\n");
    }

    public void addAddressesByAddress(CepQuery cepQuery) {
        System.out.println("Enter your state abbreviation (ex.: PE):");
        String uf = scan.nextLine();
        System.out.println("Enter your city name:");
        String city = scan.nextLine();
        System.out.println("Enter your street name:");
        String street = scan.nextLine();

        Addresses addressesByAddress = cepQuery.searchAddresses(uf, city, street);
        addressesArrayList.add(addressesByAddress);
        System.out.println("Address added successfully!\n");
    }

    public void viewAllAddresses() {
        for (Addresses addresses : addressesArrayList) {
            System.out.println(addresses.toString());
        }
    }

    public ArrayList<Addresses> getAddressesArrayList() {
        return addressesArrayList;
    }
}
