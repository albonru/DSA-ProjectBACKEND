package edu.upc.eetac.dsa.models;

import edu.upc.eetac.dsa.util.RandomUtils;

import java.util.LinkedList;

public class User {
    private String id;
    private String name;
    private String password;
    private String email;
    private Integer coins;
    private LinkedList<Item> inventory = null;

    public User() {}

    public User(String name, String password, String email) {
        this.id = RandomUtils.getId();
        this.name = name;
        this.password = password;
        this.email = email;
        this.coins = 0;
        this.inventory = new LinkedList<Item>();
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

    public LinkedList<Item> getInventory() { return this.inventory; }

    public void setInventory(Item item) { this.inventory.add(item); }

    @Override
    public String toString() {
        return "User{" + "ID='" + this.id + '\'' +
                ", username='" + this.name + '\'' +
                ", password='" + this.password + '\'' +
                ", email='" + this.email + '\'' +
                '}';
    }

    public void addToInventory(Item item) {

        this.inventory.add(item);
    }
}
