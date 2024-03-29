/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.authentication;

import dal.AccountDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;


public class SingUpController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String re_password = request.getParameter("re-password");
        String fullname = request.getParameter("fullname");
        AccountDBContext db = new AccountDBContext();
        Account acc = db.getAccountByUsername(username);
        if (password.equals(re_password)) {
            if(acc != null) {
                request.setAttribute("error", "Username has existed!");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            } else {
                db.insertAccount(username, password, fullname);
                response.sendRedirect("login");
            }
        } else {
            request.setAttribute("error", "Re-password incorrect!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
