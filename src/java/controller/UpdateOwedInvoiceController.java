
package controller;

import controller.authentication.BaseAuthentication;
import dal.InvoiceDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateOwedInvoiceController extends BaseAuthentication {
    
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idInvoice_raw = request.getParameter("idinvoice");      
        String amount_raw = request.getParameter("amount");      
        int idInvoice = Integer.parseInt(idInvoice_raw);
        long amount = Long.parseLong(amount_raw);
        InvoiceDBContext db = new InvoiceDBContext();
        db.updateOwedInvoice(idInvoice, amount);
        response.sendRedirect("owed");
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
