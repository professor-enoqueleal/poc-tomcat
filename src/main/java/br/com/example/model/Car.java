package br.com.example.model;

public class Car {

    private String id;
    private final String name;

    private final String color;

    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Car(String id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
