package edu.upc.eetac.dsa.dao;

import edu.upc.eetac.dsa.models.Question;

import java.beans.IntrospectionException;
import java.util.List;

public interface QuestionDAO {
    public Question addQuestion(Question q);
    public List<Question> getAllQuestions();
    public Question deleteQuestion(Question q) throws IntrospectionException;
}
