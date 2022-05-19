package edu.upc.eetac.dsa.dao;

import edu.upc.eetac.dsa.models.User;

import java.util.List;

public interface UserDAO {
    public void addUser(String name, String password, String email);
    public User updateUser(String oldUsername, String name, String password, String email);
    public User getUserByName(String name);
    public User getUserByEmail(String email);
    public User getUserById(String id);
    public List<User> getAllUsers();
    public void deleteUser(String name);
}
