<%-- 
    Document   : errorPage
    Created on : Oct 7, 2020, 7:41:21 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4>Product could not be deleted!!!!</h4>
        <p>
            <b>${minima}</b>
        </p>
        <!--expression Language-->
        <a href="${pageContext.request.contextPath}/ListProductServlet">Go to Product list</a>
    </body>
</html>
