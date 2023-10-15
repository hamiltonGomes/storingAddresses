package models;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressesManager {

    private final ArrayList<Addresses> addressesArrayList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public void addAddressesByCep(CepQuery cepQuery) {
        String userCep;
        do {
            System.out.println("╔══════════════════════════════════════════╗");
            System.out.println("║ Enter your CEP/zip code (Ex.: 12345678): ║");
            System.out.println("╚══════════════════════════════════════════╝");
            userCep = scan.nextLine();
            System.out.println(userCep.length());
        } while (userCep.length() != 8);

        Addresses addressByCep = cepQuery.searchCep(userCep);
        addressesArrayList.add(addressByCep);
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║ Address added successfully! ║");
        System.out.println("╚═════════════════════════════╝\n");
    }

    public void addAddressesByAddress(CepQuery cepQuery) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║ Enter your state abbreviation (Ex.: PE): ║");
        System.out.println("╚══════════════════════════════════════════╝");
        String uf = scan.nextLine();
        System.out.println("╔═══════════════════════╗");
        System.out.println("║ Enter your city name: ║");
        System.out.println("╚═══════════════════════╝");
        String city = scan.nextLine();
        System.out.println("╔═════════════════════════╗");
        System.out.println("║ Enter your street name: ║");
        System.out.println("╚═════════════════════════╝");
        String street = scan.nextLine();

        Addresses addressesByAddress = cepQuery.searchAddresses(uf, city, street);
        addressesArrayList.add(addressesByAddress);
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║ Address added successfully! ║");
        System.out.println("╚═════════════════════════════╝\n");
    }

    public void viewAllAddresses() {
        if (addressesArrayList.isEmpty()) {
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║ The address list is still empty. ║");
            System.out.println("╚══════════════════════════════════╝\n");
        }
        for (Addresses addresses : addressesArrayList) {
            System.out.println(addresses.toString());
        }
    }

    public ArrayList<Addresses> getAddressesArrayList() {
        return addressesArrayList;
    }
}
