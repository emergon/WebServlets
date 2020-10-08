<%-- 
    Document   : productCreateForm
    Created on : Oct 7, 2020, 8:44:43 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Form</title>
    </head>
    <body>
        <div align="center">
            <%@include file="../header.jsp" %>
            <h2>Create New Product</h2>
            <form action="${pageContext.request.contextPath}/product/create" method="POST" style="margin-top: 5em">
                Description : <input type="text" name="description"/> <br/>
                Price : <input type="number" name="price" /><br/>
                <input type="submit" value="Submit"/><br/>
            </form>
            <jsp:include page="../footer.jsp"/>
        </div>
    </body>
</html>
