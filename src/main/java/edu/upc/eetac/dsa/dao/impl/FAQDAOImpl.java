package edu.upc.eetac.dsa.dao.impl;

import edu.upc.eetac.dsa.dao.FAQDAO;
import edu.upc.eetac.dsa.models.FAQ;

import java.util.List;
import java.util.logging.Logger;

public class FAQDAOImpl implements FAQDAO {
    private static FAQDAOImpl manager;
    private SessionImpl session;
    static final Logger logger = Logger.getLogger(FAQDAOImpl.class.getName());


    FAQDAOImpl() {this.session = SessionImpl.getInstance();}

    public static FAQDAOImpl getInstance() {

        if(manager == null) {

            manager = new FAQDAOImpl();
        }
        return manager;
    }

    @Override
    public List<FAQ> getAllFAQ() {
        List<FAQ> faqList = this.session.getAll(FAQ.class);
        return faqList;
    }

    @Override
    public FAQ addFAQ(FAQ faq) {
        this.session.save(faq);
        return faq;
    }
}
