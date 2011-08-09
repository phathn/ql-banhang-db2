<%@page import="Persistences.*"%>
<%@page import="Repositories.*"%>
<%@page import="Helpers.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<div class="contextual">
    <%
                long total = 0;
                if (session.getAttribute("CustomerInfo") != null) {
    %>
    <div class="supportOnline">
        <h2 style="background:url(images/bgd_top_giohang.gif) no-repeat left top">Shopping Cart</h2>
        <table border="0" cellpadding="0" cellspacing="5" width="160">
            <tr>
                <td class="CartSummary">
                    <% if (session.getAttribute("ShoppingCart") == null) {%>
                    <b>Nothing in Cart.</b>
                    <% } else {
                    %>
                    <a class="CartLink" href="index.jsp?type=3">View Products in Cart</a>
                    <br/>
                    <%
                         ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
                         for (int i = 0; i < cart.getCart().size(); i++) {
                             ShoppingCartItem item = cart.getCart().get(i);
                             Products prodItem = ProductsRepository.selectByID(item.getIdProduct());
                             total += (item.getQuantity() * prodItem.getPrice());
                    %>
                    <%= String.valueOf(item.getQuantity())%> x <%= prodItem.getName()%>
                    <br/>
                    <% }
                                        }%>
                    <img src="images/line.gif" border="0" width="99%" height="1" />
                    Total money:
                    <span class="ProductPrice">
                        <%= total%> USD
                    </span>
                </td>
            </tr>
        </table>
    </div>
    <% }%>
</div>