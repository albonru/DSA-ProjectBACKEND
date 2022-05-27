package edu.upc.eetac.dsa.dao.impl;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import edu.upc.eetac.dsa.dao.InventoryDAO;
import edu.upc.eetac.dsa.models.Inventory;
import edu.upc.eetac.dsa.models.Item;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class InventoryDAOImpl implements InventoryDAO {
    List<Inventory> inventoryList = new LinkedList<>();

    static final Logger logger = Logger.getLogger(UserDAOImpl.class.getName());
    private static InventoryDAOImpl manager;

    InventoryDAOImpl() {}

    public static InventoryDAOImpl getInstance() {

        if(manager == null) {

            manager = new InventoryDAOImpl();
        }
        return manager;
    }


    @Override
    public Inventory addInventory(String userid) {
        Inventory inventory = new Inventory(userid);
        this.inventoryList.add(inventory);
        return inventory;
    }

    @Override
    public void addItem(Item item, String userid) {
        inventoryList.forEach(i -> {
            if(i.getUserId().equals(userid)) {
                i.getItemList().add(item);
            }
        });
    }

    @Override
    public Item retrieveItem(Item item, String userid) {
        inventoryList.forEach(i -> {
            if(i.getUserId().equals(userid)) {
                i.getItemList().remove(item);
            }
        });
        return item;
    }

    @Override
    public List<Item> getUserInventory(String userid) {
        for(Inventory i : inventoryList) {
            if(i.getUserId().equals(userid)) {
                return i.getItemList();
            }
        };
        return null;
    }
}
