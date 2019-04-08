package com.example.minki.eait.DTO;

import android.media.Image;

public class Category {

    private String Name;
    private String Image;
    private String Key;

    public Category() {}

    public Category(String name, String image, String key) {
        Name = name;
        Image = image;
        Key = key;
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
}
