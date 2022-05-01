package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class User {
    String id;
    String name;
    String password;
    String email;

    public User() {}

    public User(String name, String password, String email) {
        this.id = RandomUtils.getId();
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
