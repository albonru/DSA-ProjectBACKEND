package edu.upc.eetac.dsa.dao;

import edu.upc.eetac.dsa.models.Item;

import java.util.List;

public interface ItemDAO {
    public List<Item> getStoreList();
    public List<Item> getInventory(String username);
    public void buyItem(String item, String username);
    public Item getItemByName(String name);
    public void addToStore(String item);
    public void addToUser(String username, String itemname);
}
