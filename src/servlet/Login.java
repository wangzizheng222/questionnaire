package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        String answer_1=request.getParameter("que_1");
        String answer_2=request.getParameter("que_2");
        String answer_3=request.getParameter("que_3");
        String answer_4=request.getParameter("que_4");
        String answer_5=request.getParameter("que_5");
        String answer_6=request.getParameter("que_6");
        String answer_7=request.getParameter("que_7");
        String answer_8=request.getParameter("que_8");

        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }
}
