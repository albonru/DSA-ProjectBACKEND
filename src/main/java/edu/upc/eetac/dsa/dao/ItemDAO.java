package edu.upc.eetac.dsa.dao;

import edu.upc.eetac.dsa.models.Item;

import java.util.List;

public interface ItemDAO {
    public List<Item> getStoreList();
    public void buyItem(String item, String username);
    public Item getItemByName(String name);
    public Item addItem(Item item);
    public Item addToStore(String item);
}
