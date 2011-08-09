<%@page import="Persistences.*"%>
<%@page import="Repositories.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%
            Customers customerTmp = null;
            if (session.getAttribute("CustomerInfo") != null) {
                customerTmp = (Customers) session.getAttribute("CustomerInfo");
            }

            ArrayList<Productcategories> lstProdCat = ProductCategoriesRepository.selectAll();
%>
<div class="highlightLev">
    <%
                if (customerTmp == null) {
    %>
    <div class="blocMore" style="padding-bottom:3px;">
        <h2>LOGIN FORM</h2>
        <form name="login" method="post" action="Login">
            <div style="margin-top:-5px;">
                UserName:
                <input name="username" class="txtKeyword"/>
                Password:
                <input type="password" name="password" class="txtKeyword"/>
                <br />
                <br />
                <input type="submit" id="LoginButton" class="btnDangNhap" style="margin-right:35px;margin-bottom:10px;" value="Login"/>
                <br />
                <br />
                <%--<a href="index.jsp" >Register New ?</a>--%>
            </div>
        </form>

    </div>
    <%                    } else {
    %>
    <div class="blocMore" style="padding-bottom:3px;">
        <h2>LOGIN FORM</h2>
        <div style="margin-top:-5px;">
            <div class="logininfo">Hello <%=customerTmp.getName()%>,
                (<a target="_top" href="/CustomerManagerWeb/Logout">LogOut</a>)
            </div>
        </div>
    </div>
    <%                }
    %>
    <div id="navList">
        <h2>Product Category</h2>
        <div class="arrowlistmenu">
            <%
                        for (int i = 0; i < lstProdCat.size(); i++) {
            %>
            <h3 class="menuheader expandable">
                <a href="index.jsp?idcategory=<%= lstProdCat.get(i).getId()%>"><%= lstProdCat.get(i).getName()%></a>
            </h3>
            <% }%>
        </div>
    </div>
</div>