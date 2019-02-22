package com.example.Model;

public class Pcost {
    private int id;
    private String name;
    private int price;
    private String type;

    public Pcost(int id, String name, int price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type= type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return '{' + "id=" + id + ", name=" + name + ", price=" + price + ", type=" + type + '}';
    }
}