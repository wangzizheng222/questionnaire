package servlet;

import daoimpl.ManagerDaoImpl;
import daoimpl.QuestionnaireDaoImpl;
import entity.Manager;
import entity.QuestionnaireResults;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        String name=request.getParameter("name").trim();
        String password=request.getParameter("password").trim();

        ManagerDaoImpl managerDao=new ManagerDaoImpl();
        try {
            List<Manager> list=managerDao.findBy(name);
            for (Manager value:list){
                if (value.getPassword().equals(password)){
                    //获取问卷结果列表数据
                    QuestionnaireDaoImpl questionnaireDao=new QuestionnaireDaoImpl();
                    List<QuestionnaireResults> que_list=questionnaireDao.findAll();
                    request.setAttribute("list",que_list);

                    request.getRequestDispatcher("manager.jsp").forward(request,response);
                }
                else {
                    request.getRequestDispatcher("fail_login.jsp").forward(request,response);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
