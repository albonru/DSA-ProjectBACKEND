package edu.upc.eetac.dsa.dao.impl;

import edu.upc.eetac.dsa.dao.IssueDAO;
import edu.upc.eetac.dsa.models.Issue;
import edu.upc.eetac.dsa.models.Question;

import java.beans.IntrospectionException;
import java.util.List;
import java.util.logging.Logger;

public class IssueDAOImpl implements IssueDAO {

    private static IssueDAOImpl manager;
    private SessionImpl session;
    static final Logger logger = Logger.getLogger(IssueDAOImpl.class.getName());


    IssueDAOImpl() {
        this.session = SessionImpl.getInstance();
    }

    public static IssueDAOImpl getInstance() {

        if(manager == null) {

            manager = new IssueDAOImpl();
        }
        return manager;
    }

    @Override
    public Issue addIssue(Issue i) {
        logger.info("Into DAOImpl -> Issue to save: " + i.toString());

        this.session.save(i);
        return i;
    }

    @Override
    public List<Issue> getAllIssues() {
        List<Issue> list = this.session.getAll(Issue.class);

        return list;
    }

    @Override
    public void deleteIssue(Issue i) throws IntrospectionException {
        this.session.delete(i);
    }
}
