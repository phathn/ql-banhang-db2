<%@page import="Persistences.*"%>
<%@page import="Repositories.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@page import="java.io.*"%>

<%
            ArrayList<Products> lstProd;
            if (request.getParameter("idcategory") == null) {
                lstProd = ProductsRepository.selectProductNewest();
            } else {
                lstProd = ProductsRepository.selectByIDProductCategory(Integer.parseInt(request.getParameter("idcategory")));
            }
%>

<div class="topProducts">
    <h2>
        PRODUCT LIST
    </h2>
    <div class="topProductsWrap" style="padding-left:20px;">
        <% for (int i = 0; i < lstProd.size(); i++) {
        %>
        <div class="itemProducts">
            <a href="index.jsp?type=2&id=<%= lstProd.get(i).getId()%>">
                <img src="RetrieveImage.jsp?id=<%= lstProd.get(i).getId()%>" alt="<%= lstProd.get(i).getName()%>" width="100" height="90"/>
            </a>
            <h3><a href="index.jsp?type=2&id=<%= lstProd.get(i).getId()%>"><%= lstProd.get(i).getName()%></a></h3>
            <div style="bottom: -10px; position: absolute; text-align: center; width: 100%;">
                <span style="line-height:1.3em;">Price: <%= lstProd.get(i).getPrice()%> USD</span><BR />
                &nbsp;&nbsp;<span><br /></span>
                &nbsp;</div>
        </div>
        <% }%>

    </div>
</div>