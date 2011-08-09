<%@page import="Persistences.*"%>
<%@page import="Repositories.*"%>
<%@page import="Helpers.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>

<%
                        float discount = Float.parseFloat(request.getParameter("discount"));
                        if (discount != 0) {
                            discount = discount/100;
                        } else {
                            discount = 1;
                        }
            %>
<br/>
<span style="font-size:13px;font-weight:bold;color:#cc0000;">Payment information</span>
<table class="Grid" cellpadding="0" cellspacing="0">
    <thead>
        <tr>
            <th>Total Cash</th>
            <th>Discount(%)</th>
            <th>Total Pay</th>
        <tr>
    </thead>

    <tr class="Row">
        <td><span class="ProductPrice"><%= request.getParameter("totalcash")%> USD</span></td>
        <td><span class="ProductPrice"><%= request.getParameter("discount") %></span></td>
        <td><span class="ProductPrice"><%= Long.parseLong(request.getParameter("totalcash")) - (Long.parseLong(request.getParameter("totalcash")) * discount) %> USD</span></td>
    </tr>
</table>
