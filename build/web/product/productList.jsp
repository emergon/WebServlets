<%@page import="emergon.entity.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Products</title>
    </head>
    <body>
        <%
            List<Product> list = (List<Product>)request.getAttribute("products");
            for(Product p: list){
                out.print(p);
                out.print("<br/>");
            }
        %>
    </body>
</html>
