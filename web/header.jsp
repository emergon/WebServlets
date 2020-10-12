<%-- 
    Document   : header
    Created on : Oct 8, 2020, 8:09:57 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div align="center" style="margin-bottom: 3em">
    <h3>Sales Company</h3>
    <c:if test="${username != null}">
        <p>
            You are logged in as <b>${sessionScope.username}</b>
        </p>
        <p>
            <a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
        </p>
        <a href="${pageContext.request.contextPath}/ListProductServlet">
            Products
        </a>
        |
        <a href="#">
            Customers
        </a>
        |
        <a href="#">
            Salesmen
        </a>
        |
        <a href="#">
            Sales
        </a>
    </c:if>
</div>