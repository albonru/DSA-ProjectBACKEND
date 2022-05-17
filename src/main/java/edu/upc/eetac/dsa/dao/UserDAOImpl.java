package edu.upc.eetac.dsa.dao;

import edu.upc.eetac.dsa.models.User;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class UserDAOImpl implements UserDAO {

    LinkedList<User> userList = new LinkedList<>();

    static final Logger logger = Logger.getLogger(UserDAOImpl.class.getName());
    private static UserDAOImpl manager;

    private  UserDAOImpl() {}

    public static UserDAOImpl getInstance() {

        if(manager == null) {

            manager = new UserDAOImpl();
        }
        return manager;
    }

    @Override
    public void addUser(String name, String password, String email) {

        User u1 = getUserByName(name);
        User u2 = getUserByEmail(email);

        if(u1 != null) { showErrorName(); }

        else if(u2 != null) { showErrorEmail(); }

        else {
            User u = new User(name, password, email);
            this.userList.add(u);
        }
    }

    @Override
    public User updateUser(String oldUsername, String name, String password, String email) {

        User u = getUserByName(oldUsername);
        User u1 = getUserByName(name); User u2 = getUserByEmail(email);

        if(u1 != null) { showErrorName(); return null; }

        else if(u2 != null) { showErrorEmail(); return null; }

        else {
            u.setName(name); u.setPassword(password); u.setEmail(email);
            return u;
        }
    }

    @Override
    public User getUserByName(String name) {

        for (User u: this.userList) {

            if(u.getName().equals(name)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {

        for (User u: this.userList) {

            if(u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public User getUserById(String id) {

        for (User u: this.userList) {

            if(u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {

        return this.userList;
    }

    @Override
    public void deleteUser(String name) {

        User u = getUserByName(name);
        this.userList.remove(u);
    }

    public void showErrorName() { logger.info("An user with the same name already exist."); }

    public void showErrorEmail() { logger.info("An user with the same email already exist."); }
}