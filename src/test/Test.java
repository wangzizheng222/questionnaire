package test;

import daoimpl.ManagerDaoImpl;
import daoimpl.QuestionnaireDaoImpl;
import entity.Manager;
import entity.QuestionnaireResults;

import java.sql.SQLException;
import java.util.List;

/**
 * 测试功能
 * 主函数为打印所有表
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        ManagerDaoImpl managerDao=new ManagerDaoImpl();
        QuestionnaireDaoImpl questionnaireDao=new QuestionnaireDaoImpl();

        List<Manager> managerList=managerDao.findAll();
        for (Manager manager:managerList){
            System.out.println(manager);
        }

        List<QuestionnaireResults> questionnaireResultsList=questionnaireDao.findAll();
        for (QuestionnaireResults questionnaire:questionnaireResultsList){
            System.out.println(questionnaire);
        }

    }

    public void test1() throws SQLException {
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
