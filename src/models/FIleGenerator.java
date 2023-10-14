package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FIleGenerator {
    public void saveFile(ArrayList<Addresses> addresses) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter writer = new FileWriter("addressList.json", true);
        writer.write(gson.toJson(addresses));
        writer.close();
    }
}
