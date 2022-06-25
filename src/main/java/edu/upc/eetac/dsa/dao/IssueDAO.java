package edu.upc.eetac.dsa.dao;

import edu.upc.eetac.dsa.models.Issue;

import java.beans.IntrospectionException;
import java.util.List;

public interface IssueDAO {
    public Issue addIssue(Issue i);
    public List<Issue> getAllIssues();
    public void deleteIssue(Issue i) throws IntrospectionException;
}
