package edu.upc.eetac.dsa.dao.impl;

import edu.upc.eetac.dsa.dao.InventoryDAO;
import edu.upc.eetac.dsa.models.Inventory;
import edu.upc.eetac.dsa.models.Item;

import java.util.List;
import java.util.logging.Logger;

public class InventoryDAOImpl implements InventoryDAO {
    static final Logger logger = Logger.getLogger(UserDAOImpl.class.getName());
    private static InventoryDAOImpl manager;
    private SessionImpl session;

    InventoryDAOImpl() {
        this.session = SessionImpl.getInstance();
    }

    public static InventoryDAOImpl getInstance() {

        if(manager == null) {

            manager = new InventoryDAOImpl();
        }
        return manager;
    }

    // A FER
    @Override
    public Inventory addInventory(String userid) {

        return null;
    }

    // A FER
    @Override
    public void addItem(Item item, String userid) {

    }

    // A FER
    @Override
    public Item retrieveItem(Item item, String userid) {
        return null;
    }

    // A FER
    @Override
    public List<Item> getUserInventory(String userid) {
        return null;
    }
}
