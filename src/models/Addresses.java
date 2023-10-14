package models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Addresses {

    @SerializedName("cep")
    private String cep;
    @SerializedName("uf")
    private String state;
    @SerializedName("localidade")
    private String city;
    @SerializedName("bairro")
    private String neighborhood;
    @SerializedName("logradouro")
    private String street;
    private ArrayList<Addresses> addresses = new ArrayList<>();

    public void addAddresses(Addresses address) {
        addresses.add(address);
    }

    public ArrayList<Addresses> getAddresses() {
        return addresses;
    }

    @Override
    public String toString() {
        return "CEP: " + cep + "\n" +
                "City: " + city + ", " + "\n" +
                "State: " + state + ", " + "\n" +
                "Neighborhood: " + neighborhood + ", " + "\n" +
                "Street: " + street + ".";
    }
}
