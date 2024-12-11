package com.example.app;

import com.example.models.User;
import com.example.services.UserService;

public class Application {
    public static void main(String[] args) {
        User user = new User("john doe", "john@example.com");
        UserService userService = new UserService();
        String formattedInfo = userService.formatUserInfo(user);
        System.out.println(formattedInfo);
    }
}