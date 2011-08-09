<%@page import="Persistences.*"%>
<%@page import="Repositories.*"%>
<%@page import="Helpers.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>

<%
            long totalPay = 0;
            long totalCash = 0;
            ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
%>
<br />
<span style="font-size:13px;font-weight:bold;color:#cc0000;">Your Cart</span>
<table class="Grid" cellpadding="0" cellspacing="0">
    <thead>
        <tr>
            <th>Product</th>
            <th>Price (USD)</th>
            <th>Quantity</th>
            <th>Total (USD)</th>
        <tr>
    </thead>
    <%
                for (int i = 0; i < cart.getCart().size(); i++) {
                    ShoppingCartItem item = cart.getCart().get(i);
                    Products prodItem = ProductsRepository.selectByID(item.getIdProduct());
                    totalPay = (item.getQuantity() * prodItem.getPrice());
                    totalCash += totalPay;
                    if (i % 2 != 0) {
    %>
    <tr class="Row">
        <% } else {%>
    <tr class="AlternatingRow">
        <% }%>
        <td><%= prodItem.getName()%></td>
        <td><%= prodItem.getPrice()%></td>
        <td><%= item.getQuantity()%></td>
        <td><%= totalPay%></td>
    </tr>
    <%                }
    %>
</table>
<br />
<form name="login" method="post" action="Payment">
    <table width="100%">
        <tr>
            <td style="width:500px">
                <span class="ProductDescription">
                    Total cash:
                </span>
                <span class="ProductPrice"><%= totalCash%> USD</span>
                <input type="hidden" name="txtTotalCash" value="<%= totalCash%>"/>
            </td>
            <td>

            </td>
        </tr>
        <tr>
            <td style="width:500px">
                <span class="ProductDescription">
                    Using Promotion Code: <input name="txtPromotionCode" type="text" style="color: red; font-weight: bold">
                </span>
                <span class="ProductPrice"></span>
            </td>
            <td>
                <input type="submit" class="btnCheckOut" value="Payment">
            </td>
        </tr>
    </table>
</form>
<br />
