package edu.upc.eetac.dsa.dao;

import edu.upc.eetac.dsa.models.Inventory;
import edu.upc.eetac.dsa.models.Item;

import java.util.List;

public interface InventoryDAO {
    public Inventory addInventory(String userid);
    public void addItem(Item item, String userid);
    public Item retrieveItem(Item item, String userid);
    public List<Item> getUserInventory(String username);
}
