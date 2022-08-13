package com.juanmanuelcastillo.moneymanager.users;


import java.util.ArrayList;

public class InMemoryUsers implements Users{
    private ArrayList<User> usersItems;

    public InMemoryUsers() {
        this.usersItems = new ArrayList<>();
    }

    @Override
    public void add(User user) {
        this.usersItems.add(user);
    }

    @Override
    public User findBy(String name) {
        for (User user: usersItems) {
          if (user.name.equals(name)) return user;
        }
        return null;
    }
}
