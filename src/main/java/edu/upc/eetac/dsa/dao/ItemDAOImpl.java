package edu.upc.eetac.dsa.dao;

import edu.upc.eetac.dsa.models.Item;
import edu.upc.eetac.dsa.models.User;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class ItemDAOImpl implements ItemDAO {

    UserDAOImpl userManager;
    LinkedList<Item> storeList = new LinkedList<>();

    static final Logger logger = Logger.getLogger(ItemDAOImpl.class.getName());
    private static ItemDAOImpl manager;

    private  ItemDAOImpl() {}

    public static ItemDAOImpl getInstance() {

        if(manager == null) {

            manager = new ItemDAOImpl();
        }
        return manager;
    }

    @Override
    public List<Item> getInventory(String username) {

        User u = userManager.getUserByName(username);
        return u.getInventory();
    }

    @Override
    public List<Item> getStoreList() {

        return this.storeList;
    }

    // INCOMPLETE
    @Override
    public void buyItem(String item, String username) {

        User u = userManager.getUserByName(username);
        Item i = getItemByName(item);

        u.setInventory(i);
    }

    @Override
    public Item getItemByName(String name) {

        for (Item i: this.storeList) {

            if(i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void addToStore(String itemName) {
        Item item = this.getItemByName(itemName);
        this.storeList.add(item);
    }

    @Override
    public void addToUser(String username, String itemname) {
        User user = this.userManager.getUserByName(username);
        Item item = this.getItemByName(itemname);
        user.addToInventory(item);
    }
}
