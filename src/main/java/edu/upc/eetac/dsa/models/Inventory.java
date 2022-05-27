package edu.upc.eetac.dsa.models;

import edu.upc.eetac.dsa.util.RandomUtils;

import java.util.LinkedList;
import java.util.List;

public class Inventory {
    private String id;
    private String userId;
    private List<Item> itemList = null;

    public Inventory(String userId) {
        this.id = RandomUtils.getId();
        this.userId = userId;
        this.itemList = new LinkedList<>();
    }

    public Inventory() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
