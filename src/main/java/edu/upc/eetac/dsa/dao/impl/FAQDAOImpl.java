package edu.upc.eetac.dsa.dao.impl;

import edu.upc.eetac.dsa.dao.FAQDAO;
import edu.upc.eetac.dsa.models.FAQ;

import java.util.ArrayList;

public class FAQDAOImpl implements FAQDAO {
    private static FAQDAOImpl manager;
    ArrayList<FAQ> FAQList = new ArrayList<FAQ>();
    FAQDAOImpl() {}

    public static FAQDAOImpl getInstance() {

        if(manager == null) {

            manager = new FAQDAOImpl();
        }
        return manager;
    }
    @Override
    public ArrayList<FAQ> getAllFAQ() {
        ArrayList<FAQ> List = new ArrayList<FAQ>();
        List = FAQList;
        return List;
    }

    @Override
    public FAQ addFAQ(FAQ faq) {
        this.FAQList.add(faq);
        return faq;
    }
}
