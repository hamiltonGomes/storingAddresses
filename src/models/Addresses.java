package models;

public record Addresses(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf) {
    @Override
    public String toString() {
        return "CEP: " + cep + "\n" +
                "Street: " + logradouro + "\n" +
                "Neighborhood: " + bairro + "\n" +
                "City: " + localidade + "\n" +
                "State: " + uf;
    }
}