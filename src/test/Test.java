package test;

import daoimpl.ManagerDaoImpl;
import daoimpl.QuestionnaireDaoImpl;
import entity.Manager;
import entity.QuestionnaireResults;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        ManagerDaoImpl managerDao=new ManagerDaoImpl();
        QuestionnaireDaoImpl questionnaireDao=new QuestionnaireDaoImpl();

        managerDao.add(new Manager("root","123"));
        managerDao.add(new Manager("wzz","123"));

        List<Manager> managerList=managerDao.findAll();
        for (Manager manager:managerList){
            System.out.println(manager);
        }

        questionnaireDao.add(new QuestionnaireResults("1","2020-1-1","1",new String[]{"a","b","c"}));

        List<QuestionnaireResults> questionnaireResultsList=questionnaireDao.findAll();
        for (QuestionnaireResults questionnaire:questionnaireResultsList){
            System.out.println(questionnaire);
        }

    }
}
