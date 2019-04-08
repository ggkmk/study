package com.example.minki.eait.DTO;

public class Child {

    private String Name;
    private String Image;
    private String Key;
    private String Description;
    private int Price;

    public Child() {}

    public Child(String name, String image, String key, String description, int price) {
        Name = name;
        Image = image;
        Key = key;
        Description = description;
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
