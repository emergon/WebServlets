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
            <h2>List of Products</h2>
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
                            <a href="javascript:delete(${p.pcode})">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <script>
            function delete(productId){
                if(confirm('Do you realy want to delete product:'+productId+'????')){
                    window.location = 'product/deleteProduct?id='+productId;
                }
            }
        </script>
    </body>
</html>
