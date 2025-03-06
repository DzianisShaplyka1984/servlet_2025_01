package com.academy.service;

import com.academy.model.User;
import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private List<User> users;

    public AuthService() {
        users = new ArrayList<User>();

        User ivan = new User("Ivan", "qwert");
        User test = new User("test", "qwert");

        users.add(ivan);
        users.add(test);
    }

    public boolean authenticate(String login, String password) {
        if (login.isEmpty() || password.isEmpty()) {
            return false;
        }

        for (User user : users) {
            if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                return true;
            }
        }

        return false;
    }
}
