package edu.upc.dsa.managers;

import edu.upc.dsa.models.User;

import java.util.List;

public interface UserManager {
    public void addUser(String name, String password, String email);
    public User updateUser(User oldUser, String name, String password, String email);
    public User getUserByName(String name);
    public User getUserById(String id);
    public List<User> getAllUsers();
    public void deleteUser(String name);
}
