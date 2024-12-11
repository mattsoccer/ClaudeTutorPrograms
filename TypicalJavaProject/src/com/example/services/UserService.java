package com.example.services;

import com.example.models.User;
import com.example.utils.StringHelper;

public class UserService {
    public String formatUserInfo(User user) {
        String capitalizedName = StringHelper.capitalize(user.getName());
        return String.format("User: %s, Email: %s", capitalizedName, user.getEmail());
    }
}