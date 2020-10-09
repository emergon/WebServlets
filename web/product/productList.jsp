<%@page import="emergon.entity.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Products</title>
    </head>
    <body>
        <div align="center">
            <%@include file="../header.jsp" %>
            <h2>List of Products</h2>
            <a href="${pageContext.request.contextPath}/product/create">Create New Product</a>
            <br/>
            <br/>
            ${param.minima}
            <br/>
            <table border="1">
                <c:forEach items="${products}" var="p">
                    <tr>
                        <td>${p.pcode}</td>
                        <td>${p.pdescr}</td>
                        <td>${p.pprice}</td>
                        <td>
                            <a href="product/editProduct?id=${p.pcode}">Edit</a>
                        </td>
                        <td>
                            <a href="product/deleteProduct?id=${p.pcode}" onclick="return confirm('Do you realy want to delete product:'+${p.pcode}+'????')">Delete</a>
                            
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="../footer.jsp"/>
            This is my Global Initial Parameter : ${Country}
            <br/>
            The images of each product will be uploaded to : ${location}
        </div>

    </body>
</html>
