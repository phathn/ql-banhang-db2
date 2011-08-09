<%-- 
    Document   : index
    Created on : Jul 24, 2011, 11:56:33 AM
    Author     : db2admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Content/common.css"  rel="stylesheet" type="text/css" media="screen" />
        <link href="Content/GridPager.css"  rel="stylesheet" type="text/css" media="screen" />
        <style type="text/css">
            .arrowlistmenu{
                width: 160px; /*width of accordion menu*/
            }

            .arrowlistmenu .menuheader{ /*CSS class for menu headers in general (expanding or not!)*/
                                        font: bold 12px Arial;
                                        color: #333333;
                                        background: black url(images/titlebar.png) repeat-x center left;
                                        margin-bottom: 1px; /*bottom spacing between header and rest of content*/
                                        text-transform: uppercase;
                                        padding: 4px 0 4px 10px; /*header text is indented 10px*/
                                        cursor: hand;
                                        cursor: pointer;
            }

            .arrowlistmenu .openheader{ /*CSS class to apply to expandable header when it's expanded*/
                                        background-image: url(images/titlebar-active.png);
                                        color: white;
            }

            .arrowlistmenu ul{ /*CSS for UL of each sub menu*/
                               list-style-type: none;
                               margin: 0;
                               padding: 0;
            }

            .arrowlistmenu ul li{
                padding-bottom: 2px; /*bottom spacing between menu items*/
            }

            .arrowlistmenu ul li a{
                color: #A70303;
                background: url(images/arrowbullet.png) no-repeat center left; /*custom bullet list image*/
                display: block;
                padding: 2px 0;
                padding-left: 19px; /*link text is indented 19px*/
                text-decoration: none;
                font-weight: bold;
                border-bottom: 1px solid #dadada;
                font-size: 90%;
            }

            .arrowlistmenu ul li a:visited{
                color: #A70303;
            }

            .arrowlistmenu ul li a:hover{ /*hover state CSS*/
                                          color: #A70303;
                                          background-color: #F3F3F3;
            }
        </style>
    </head>
    <body>
        <div id="container">
            <%@include file="UC_Header.jsp" %>
            <div id="contentMain">
                <%@include file="UC_LeftColumn.jsp" %>
                <div class="contentCenter" id="contentCenter">
                    <%
                                int v = 1;
                                if (request.getParameter("type") != null) {
                                    v = Integer.parseInt(request.getParameter("type"));
                                }
                    %>
                    <%
                                switch (v) {
                                    case 1:
                    %>
                    <%@include file="UC_ProductList.jsp" %>
                    <%
                                                            break;
                                                        case 2:
                    %>
                    <%@include file="UC_ProductDetail.jsp" %>
                    <%
                                                            break;
                                                        case 3:
                    %>
                    <%@include file="UC_Payment.jsp" %>
                    <%
                                                            break;
                                                        case 4:
                    %>
                    <%@include file="UC_PaymentInfo.jsp" %>
                    <%
                                        break;
                                }
                    %>
                </div>
                <%@include file="UC_RightColumn.jsp" %>
            </div>
        </div>
    </body>
</html>
