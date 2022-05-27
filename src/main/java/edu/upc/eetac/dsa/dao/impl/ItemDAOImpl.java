package edu.upc.eetac.dsa.dao.impl;

import edu.upc.eetac.dsa.dao.ItemDAO;
import edu.upc.eetac.dsa.dao.UserDAO;
import edu.upc.eetac.dsa.models.Item;
import edu.upc.eetac.dsa.models.User;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class ItemDAOImpl implements ItemDAO {

    UserDAO userManager = UserDAOImpl.getInstance();
    LinkedList<Item> storeList = new LinkedList<>();
    LinkedList<Item> itemList = new LinkedList<>();

    static final Logger logger = Logger.getLogger(ItemDAOImpl.class.getName());
    private static ItemDAOImpl manager;

    private  ItemDAOImpl() {}

    public static ItemDAOImpl getInstance() {

        if(manager == null) {

            manager = new ItemDAOImpl();
        }
        return manager;
    }

    // FUNCIONA
    @Override
    public List<Item> getStoreList() {
        return this.storeList;
    }

    // INCOMPLETO
    @Override
    public void buyItem(String item, String username) {

        User u = userManager.getUserByName(username);
        Item i = getItemByName(item);

        //u.addToInventory(i);
    }

    // FUNCIONA
    @Override
    public Item getItemByName(String name) {

        for (Item i: this.itemList) {

            if(i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    public Item addItem(Item item) {
        this.itemList.add(item);
        return item;
    }

    // FUNCIONA
    @Override
    public Item addToStore(String itemName) {
        Item item = this.getItemByName(itemName);
        if (item == null)
            return null;
        this.storeList.add(item);
        return item;
    }
}
