package edu.upc.dsa.managers;

import edu.upc.dsa.models.User;

import java.util.List;

public interface UserManager {
    public void addUser(String name, String password, String email);
    public User getUser(String name);
    public List<User> getAllUsers();
    public void deleteUser(String name);
}
