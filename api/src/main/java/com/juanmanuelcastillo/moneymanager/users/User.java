package com.juanmanuelcastillo.moneymanager.users;

public class User {
    String name;
    String surname;
    String password;
    String email;
    String date;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public User(String name, String surname, String password, String email, String date) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.date = date;
    }
}

