package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FIleGenerator {
    private int index = 0;

    public void saveFile(ArrayList<AddressesCep> addresses) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter writer = new FileWriter("addressList.json", false);
        writer.write(gson.toJson(addresses));
        writer.close();
    }
}
