package dao;

import entity.QuestionnaireResults;

import java.sql.SQLException;
import java.util.List;

public interface QuestionnaireDao {
    public void add(QuestionnaireResults questionnaireResults) throws SQLException;
    public void delete(String id) throws SQLException;
    public List<QuestionnaireResults> findBy(String id) throws SQLException;
    public List<QuestionnaireResults> findAll() throws SQLException;
}
