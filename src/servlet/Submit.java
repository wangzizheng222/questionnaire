package servlet;

import daoimpl.QuestionnaireDaoImpl;
import entity.QuestionnaireResults;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/submit")
public class Submit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        //获取id
        QuestionnaireDaoImpl questionnaireDao_1=new QuestionnaireDaoImpl();
        String id= null;
        try {
            id = String.valueOf(questionnaireDao_1.findAll().size()+1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //获取题目
        String title="honesty";

        //获取问卷结果

        String answer_1=request.getParameter("que_1").trim();
        String answer_2=request.getParameter("que_2").trim();
        String answer_3=request.getParameter("que_3").trim();
        String answer_4=request.getParameter("que_4").trim();
        String answer_5=request.getParameter("que_5").trim();
        String answer_6=request.getParameter("que_6").trim();
        String answer_7=request.getParameter("que_7").trim();
        String answer_8=request.getParameter("que_8").trim();

        String[] choice=new String[8];
        choice[0]=answer_1;
        choice[1]=answer_2;
        choice[2]=answer_3;
        choice[3]=answer_4;
        choice[4]=answer_5;
        choice[5]=answer_6;
        choice[6]=answer_7;
        choice[7]=answer_8;



        //获取日期
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String date=df.format(new Date(System.currentTimeMillis()));


        //传递数据
        QuestionnaireDaoImpl questionnaireDao=new QuestionnaireDaoImpl();
        try {
            questionnaireDao.add(new QuestionnaireResults(id,date,title,choice));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }
}
