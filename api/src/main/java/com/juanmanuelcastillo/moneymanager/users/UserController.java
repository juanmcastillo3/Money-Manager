package com.juanmanuelcastillo.moneymanager.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;

@RestController
class UserController {
    Users users = new InMemoryUsers();

    @PostMapping("/users")
    public String newUser(@RequestBody User user) {
        LocalDate userDate = LocalDate.parse(user.date);
        int userAge = Period.between(userDate, LocalDate.now()).getYears();
        if (userAge <= 18) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Minor User");
        } if (user.password.length() <= 8 || !user.password.matches("^[a-zA-Z0-9_.-]*$")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Password");
        }
        users.add(user);
        return "User created";
    }

    @GetMapping("/users/{name}")
    public String findUserByName(@PathVariable String name) {
        User user = users.findBy(name);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found");
        }
        return user.toString();
    }
}