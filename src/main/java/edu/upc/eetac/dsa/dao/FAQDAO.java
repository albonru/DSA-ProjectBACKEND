package edu.upc.eetac.dsa.dao;

import edu.upc.eetac.dsa.models.FAQ;

import java.util.ArrayList;
import java.util.List;

public interface FAQDAO {
    public ArrayList<FAQ> getAllFAQ();
 public FAQ addFAQ(FAQ faq);
}
