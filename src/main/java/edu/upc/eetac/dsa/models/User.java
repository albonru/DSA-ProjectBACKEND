package edu.upc.eetac.dsa.models;

import edu.upc.eetac.dsa.util.RandomUtils;

public class User {
    private String id;
    private String name;
    private String password;
    private String email;
    private Integer coins;
    private String language;
    private int points;

    public User() {}

    public User(String name, String password, String email) {
        this.id = RandomUtils.getId();
        this.name = name;
        this.password = password;
        this.email = email;
        this.coins = 0;
        this.language = "en";
        this.points = 0;
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

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", coins=" + coins +
                ", languaje='" + language + '\'' +
                ", points='" + points + '\'' +
                '}';
    }
}
