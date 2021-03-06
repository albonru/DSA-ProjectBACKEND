package edu.upc.eetac.dsa.dao;

import edu.upc.eetac.dsa.models.User;

import java.beans.IntrospectionException;
import java.util.List;

public interface UserDAO {
    public User addUser(String name, String password, String email);
    public User updateUser(String oldUsername, String name, String password, String email) throws IntrospectionException;
    public User updateCoins(String name, int coins) throws IntrospectionException;
    public User updatePoints(String name, int points) throws IntrospectionException;
    public User getUserById(String id);
    public User getUserByName(String name);
    public User getUserByEmail(String email);
    public List<User> getAllUsers();
    public List<User> getCoinRanking();
    public List<User> getPointRanking();
    public void deleteUser(String name) throws IntrospectionException;
    public User changeLanguage(String username, String language) throws IntrospectionException;
}
