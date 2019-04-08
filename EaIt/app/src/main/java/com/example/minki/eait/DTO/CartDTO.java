package com.example.minki.eait.DTO;

public class CartDTO {

    private String cart_Name;
    private String cart_Count;
    private String cart_Price;

    public CartDTO(String cart_Name, String cart_Count, String cart_Price) {
        this.cart_Name = cart_Name;
        this.cart_Count = cart_Count;
        this.cart_Price = cart_Price;
    }

    public CartDTO() {}

    public String getCart_Name() {
        return cart_Name;
    }

    public void setCart_Name(String cart_Name) {
        this.cart_Name = cart_Name;
    }

    public String getCart_Count() {
        return cart_Count;
    }

    public void setCart_Count(String cart_Count) {
        this.cart_Count = cart_Count;
    }

    public String getCart_Price() {
        return cart_Price;
    }

    public void setCart_Price(String cart_Price) {
        this.cart_Price = cart_Price;
    }
}
