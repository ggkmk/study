package com.example.minki.eait.DTO;

public class UserDTO {

    private String Name;
    private String Password;

    public UserDTO() {}

    public UserDTO(String name, String password) {
        Name = name;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
