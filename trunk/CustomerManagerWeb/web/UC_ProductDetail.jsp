<%@page import="Persistences.*"%>
<%@page import="Repositories.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>

<%
            Products prod = ProductsRepository.selectByID(Integer.parseInt(request.getParameter("id")));
%>

<div class="contentCenter" id="contentCenter">
    <div class="listItemProduct">
        <div class="meaLeft">
            <div class="pictDesc">
                <h2>Product Category</h2>
                <img src="RetrieveImage.jsp?id=<%= prod.getId()%>" alt="<%= prod.getName()%>" width="160" height="160" style="padding-top: 10px;"/>
            </div>
            <%
                        if (session.getAttribute("CustomerInfo") != null) {
            %>
            <div class="pollProducts">
                <h4>
                    <a href="/CustomerManagerWeb/BuyProduct?idproduct=<%= prod.getId()%>">Buy product</a>
                </h4>
                <h4><a href="index.jsp">Continue shopping</a></h4>
            </div>
            <% }%>
        </div>
        <div class="meaRigt">
            <h3>Product infomation</h3>
            <ul>
                <li><span>Product Category:</span><strong><%= prod.getIdproductcategory().getName()%></strong></li>
                <li><span>Producer:</span><strong><%= prod.getIdproducer().getName()%></strong></li>
                <li><span>Product name:</span><strong><%= prod.getName()%></strong></li>
                <li><span>Price:</span><strong><%= prod.getPrice()%> USD </strong></li>
                <li><span>Distributer:</span><strong><%= prod.getIddistributor().getName()%></strong></li>
            </ul>
        </div>
    </div>
</div>