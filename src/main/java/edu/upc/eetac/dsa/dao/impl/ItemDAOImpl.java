package edu.upc.eetac.dsa.dao.impl;

import edu.upc.eetac.dsa.dao.ItemDAO;
import edu.upc.eetac.dsa.models.Item;
import edu.upc.eetac.dsa.models.User;

import java.util.List;
import java.util.logging.Logger;

public class ItemDAOImpl implements ItemDAO {

    //UserDAO userManager = UserDAOImpl.getInstance();
    static final Logger logger = Logger.getLogger(ItemDAOImpl.class.getName());
    private static ItemDAOImpl manager;
    private SessionImpl session;

    private  ItemDAOImpl() {
        this.session = SessionImpl.getInstance();
    }

    public static ItemDAOImpl getInstance() {

        if(manager == null) {

            manager = new ItemDAOImpl();
        }
        return manager;
    }

    // FET
    @Override
    public List<Item> getStoreList() {
        List<Item> storeList = this.session.getAll(Item.class);
        return storeList;
    }

    // A MITGES
    @Override
    public void buyItem(String item, String username) {

        User u = (User) this.session.getByName(User.class, username);
        Item i = (Item) this.session.getByName(Item.class, item);

        //u.addToInventory(i);
    }

    // FET
    public Item addItem(Item item) {
        this.session.save(item);
        logger.info("Item saved: " + item.toString());
        return item;
    }
}
