package com.example.ncs_nguyenmanhnamt2009a.dao.servlet;

import com.example.ncs_nguyenmanhnamt2009a.dao.dao.UserDao;
import com.example.ncs_nguyenmanhnamt2009a.dao.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao dao = new UserDao();

        String username = request.getParameter("username");

        String password = request.getParameter("password");

        User user = dao.getUser(username, password);

//        PrintWriter out = response.getWriter();
//        out.append(user.toString());
//        out.close();


        if (user != null) {
            response.sendRedirect("index.jsp");

        }else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}