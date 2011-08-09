/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Helpers.*;
import Persistences.*;
import Repositories.*;
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
import org.hibernate.*;
/**
 *
 * @author db2admin
 */
public class Payment extends HttpServlet {

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

            Customers customer = ((Customers) session.getAttribute("CustomerInfo"));
            ShoppingCart ObjShoppingCart = null;

            if (session.getAttribute("ShoppingCart") == null) {
                response.sendRedirect("index.jsp");
                return;
            } else {
                ObjShoppingCart = (ShoppingCart) session.getAttribute("ShoppingCart");
            }

            if (ObjShoppingCart.getCart().size() == 0) {
                response.sendRedirect("index.jsp");
                return;
            }

            // Every buy, update customer category
            UpdateCustomerCategory(customer);

            String totalCash = request.getParameter("txtTotalCash");
            String PromotionCode = request.getParameter("txtPromotionCode");
            float discount = 0;
            // Checking promotion code is valid
            if (IsPromotionCodeValid(PromotionCode)) {
                discount = CustomersRepository.selectByID(customer.getId()).getIdcategory().getDiscount();
            }

            // Insert new order
            Orders newOrder = new Orders();
            newOrder.setIdcustomer(customer);
            newOrder.setOrderdate(new Date());
            newOrder.setDiscount(discount);
            if (OrdersRepository.insert(newOrder)) {
                // Insert order detail
                for (int i = 0; i < ObjShoppingCart.getCart().size(); i++) {
                    Orderdetails orderDetail = new Orderdetails();

                    Session sess = HibernateUtil.getSessionFactory().openSession();
                    
                    Products prod = (Products) sess.get(Products.class, ObjShoppingCart.getCart().get(i).getIdProduct());
                    orderDetail.setIdorder(newOrder);
                    orderDetail.setIdproduct(prod);
                    orderDetail.setPrice(prod.getPrice());
                    orderDetail.setQuantity(ObjShoppingCart.getCart().get(i).getQuantity());

                    Transaction tr = sess.beginTransaction();

                    sess.save(orderDetail);

                    tr.commit();
                    sess.close();
                }
            }
            session.setAttribute("ShoppingCart", null);
            response.sendRedirect("index.jsp?type=4&totalcash=" + totalCash + "&discount=" + discount);
        } finally {
            out.close();
        }
    }

    public void UpdateCustomerCategory(Customers customer) {
        ArrayList<Orders> lstItem = OrdersRepository.selectByIDCustomer(customer.getId());
        long total = 0;
        for (int i = 0; i < lstItem.size(); i++) {
            Orders orderItem = lstItem.get(i);
            ArrayList<Orderdetails> lstDetail = OrderDetailsRepository.selectByOrder(orderItem.getId());
            for (int j = 0; j < lstDetail.size(); j++) {
                total += (lstDetail.get(j).getPrice() * lstDetail.get(j).getQuantity());
            }
        }
        Customercategories cusCate = null;
        if (total < GlobalVars.BRONZE_CUSTOMER) {
            cusCate = CustomerCategoriesRepository.selectByID(4);
        } else if (total < GlobalVars.SILVER_CUSTOMER) {
            cusCate = CustomerCategoriesRepository.selectByID(3);
        } else if (total < GlobalVars.GOLDEN_CUSTOMER) {
            cusCate = CustomerCategoriesRepository.selectByID(2);
        } else {
            cusCate = CustomerCategoriesRepository.selectByID(1);
        }
        customer.setIdcategory(cusCate);
        CustomersRepository.save(customer);
    }

    public boolean IsPromotionCodeValid(String promotioncode) {
        return (SalePromotionRepository.selectByCode(promotioncode).size() > 0);
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
