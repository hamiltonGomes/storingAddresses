package main;

import models.AddressesManager;
import models.CepQuery;
import models.FIleGenerator;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        int userResponseOption;

        Scanner scan = new Scanner(System.in);
        CepQuery cepQuery = new CepQuery();
        FIleGenerator fIleGenerator = new FIleGenerator();
        AddressesManager addressesManager = new AddressesManager();


        do {
            printMenu();
            userResponseOption = scan.nextInt();

            switch (userResponseOption) {
                case 1:
                    addressesManager.addAddressesByCep(cepQuery);
                    break;
                case 2:
                    addressesManager.addAddressesByAddress(cepQuery);
                    break;
                case 3:
                    addressesManager.viewAllAddresses();
                    break;
                case 4:
                    break;
            }
        } while (userResponseOption != 4);

        fIleGenerator.saveFile(addressesManager.getAddressesArrayList());
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("╔═════════════════════════════════════════════╗");
        System.out.println("║                    MENU                     ║ ");
        System.out.println("║ 1. Add an address by CEP                    ║");
        System.out.println("║ 2. Add an address by State, City and Street ║");
        System.out.println("║ 3. View addresses                           ║");
        System.out.println("║ 4. Exit                                     ║");
        System.out.println("╚═════════════════════════════════════════════╝");
        System.out.print("Select an option: ");
    }
}
