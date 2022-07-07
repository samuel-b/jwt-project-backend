package com.example.jwtproject.service;

import com.example.jwtproject.model.Role;
import com.example.jwtproject.model.User;

import java.util.List;

public interface UserService {
    //Method that saves user and accepts user information.
    User createUser(User user);
    //Method that saves a role and accepts the role.
    Role createRole (Role role);
    //Method that applies a role to a user, it is assumed that all usernames are unique
    void addRoleToUser (String username,String roleName);
    //Method that returns a specific user
    User getUser(String username);
    //Method that returns a list of all users, in a real life scenario may want to return pages
    List<User>getUsers();
}
