/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.authentication.BaseAuthentication;
import dal.DimensionDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dimension;


public class InsertDimensionController extends BaseAuthentication {


    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("../insertdimension.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name =  request.getParameter("name");
        Dimension dimension = new Dimension();
        dimension.setName(name);
        DimensionDBContext db = new DimensionDBContext();
        db.insertDimension(dimension);
        response.sendRedirect("../insert");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
