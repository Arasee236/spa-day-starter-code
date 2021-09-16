package org.launchcode.spaday.controllers.data;

import org.launchcode.spaday.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserData {

    private static final Map<Integer, User> users = new HashMap<>();

    public static void addUser(User user){
        users.put(user.getId(),user);
    }
}
