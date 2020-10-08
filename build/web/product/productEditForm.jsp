<%-- 
    Document   : productEditForm
    Created on : Oct 8, 2020, 6:26:21 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Product</title>
    </head>
    <body>
        <div align="center">
            <%@include file="../header.jsp" %>
            <h2>Edit Product</h2>
            <form action="${pageContext.request.contextPath}/product/editProduct" method="POST" style="margin-top: 5em">
                Code : <input type="text" name="pcode" value="${proion.pcode}" readonly/><br/>
                Description : <input type="text" name="description" value="${proion.pdescr}"/> <br/>
                Price : <input type="number" name="price" step="0.01" min="0" value="${proion.pprice}"/><br/>
                <input type="submit" value="Submit"/><br/>
            </form>
            <jsp:include page="../footer.jsp"/>
        </div>
    </body>
</html>
