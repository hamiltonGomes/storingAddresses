package models;

import com.google.gson.annotations.SerializedName;

public class Addresses {

    @SerializedName("uf")
    private String state;
    @SerializedName("localidade")
    private String city;
    @SerializedName("bairro")
    private String neighborhood;
    @SerializedName("logradouro")
    private String street;

    public Addresses(String state, String city, String neighborhood, String street) {
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return "Addresses: " + "\n" +
                "City: " + city + ", " + "\n" +
                "State: " + state + ", " + "\n" +
                "Neighborhood: " + neighborhood + ", " + "\n" +
                "Street: " + street + ".";
    }
}
