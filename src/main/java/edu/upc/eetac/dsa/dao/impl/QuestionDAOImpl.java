package edu.upc.eetac.dsa.dao.impl;

import edu.upc.eetac.dsa.dao.QuestionDAO;
import edu.upc.eetac.dsa.models.Question;

import java.util.logging.Logger;

public class QuestionDAOImpl implements QuestionDAO {

    private static QuestionDAOImpl manager;
    private SessionImpl session;
    static final Logger logger = Logger.getLogger(QuestionDAOImpl.class.getName());


    QuestionDAOImpl() {
        this.session = SessionImpl.getInstance();
    }

    public static QuestionDAOImpl getInstance() {

        if(manager == null) {

            manager = new QuestionDAOImpl();
        }
        return manager;
    }

    @Override
    public Question addQuestion(Question q) {
        logger.info("Into DAOImpl -> Question to save: " + q.toString());

        //this.session.save(q);
        return q;
    }
}
