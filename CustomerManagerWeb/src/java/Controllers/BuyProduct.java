/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Helpers.GlobalVars;
import Helpers.ShoppingCart;
import Helpers.ShoppingCartItem;
import Persistences.Customers;
import Repositories.CustomersRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Object;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author db2admin
 */
public class BuyProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession(true);

            int idcustomer = ((Customers) session.getAttribute("CustomerInfo")).getId();
            String idproduct = request.getParameter("idproduct");

            ShoppingCart ObjShoppingCart = null;
            if (session.getAttribute("ShoppingCart") == null) {
                ObjShoppingCart = new ShoppingCart();
            } else {
                ObjShoppingCart = (ShoppingCart) session.getAttribute("ShoppingCart");
            }
            AtomicReference<ShoppingCartItem> refItem = new AtomicReference<ShoppingCartItem>();;
            ShoppingCartItem item = null;
            if (GlobalVars.IsProductExistInCart(ObjShoppingCart.getCart(), Integer.parseInt(idproduct), refItem)) {
                // Update exist item
                item = refItem.get();
                item.setQuantity(item.getQuantity() + 1);
            } else {
                // Insert new item
                item = new ShoppingCartItem();
                item.setIdCustomer(idcustomer);
                item.setIdProduct(Integer.parseInt(idproduct));
                item.setQuantity(1);
                ObjShoppingCart.getCart().add(item);
            }
            session.setAttribute("ShoppingCart", ObjShoppingCart);
            response.sendRedirect("index.jsp?type=2&id=" + idproduct);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
