package pl.itacademy.testsportal.model;

public enum IndexHeaders {

    NAME("Imie"),
    SURNAME("Nazwisko"),
    INDEX_NUMBER("Numer indeksu");

    private String name;

    IndexHeaders(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
