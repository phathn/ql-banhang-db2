<%@page import="Persistences.*"%>
<%@page import="Repositories.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%
    Products prod = ProductsRepository.selectByID(Integer.parseInt(request.getParameter("id")));
    byte[] imgData = prod.getPhoto();

    try {
        response.setContentType("image/gif");
        OutputStream o = response.getOutputStream();
        o.write(imgData);
        o.flush();
        o.close();
    } catch (Exception e) {
        out.println("Unable To Display image");
        out.println("Image Display Error=" + e.getMessage());
        return;
    }
%>