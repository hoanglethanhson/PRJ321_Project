/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProductContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Invoice;
import model.InvoiceLine;
import model.Product;

/**
 *
 * @author Admin
 */
public class ShoppingBuyController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ProductID = Integer.parseInt(request.getParameter("productID"));
        ProductContext db = new ProductContext();
        Product product = db.get(ProductID);
        
        HttpSession session = request.getSession(true);
        Invoice invoice = (Invoice)session.getAttribute("shoppingcart");
        
       
                
        if(invoice==null)
            invoice = new Invoice();
         ArrayList<InvoiceLine> lines = invoice.getLines();
        
        boolean isExist = false;
        for (InvoiceLine line : lines) {
            if(line.getProduct().getID() ==  product.getID())
            {
                line.setQuantity( line.getQuantity() + 1 );
                isExist = true;
                break;
            }
        }
        if(!isExist) //first time buy this product
        {
            InvoiceLine line = new InvoiceLine();
            line.setProduct(product);
            line.setQuantity(1);
            line.setUnitPrice(product.getPrice());
            lines.add(line);
        }
        
        session.setAttribute("shoppingcart", invoice);
        response.sendRedirect("../product/list");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
