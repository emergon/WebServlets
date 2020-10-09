<%-- 
    Document   : index
    Created on : Oct 6, 2020, 6:31:19 PM
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
        <jsp:include page="header.jsp"/>
        <div>Hello from my new Web application. This is my JSP page!</div>

        <p>
            <strong>
                This is a message from expression jsp tag: <%=" Expression JSP tag!!!"%>
                <br/>
                Math calculations: <%= 10 + 5%>
                <br/>
                Math calculations: <% out.print(10+6); %>
            </strong>
        </p>

        <%--This is a scriptlet in my jsp page
        <%
            printMessage(out);
            for (int i = 0; i < 10; i++) {
                out.println("<br/>number:" + i);
            }
        %>
        --%>
        <ul>
            <li>
                <!--relative urls-->
                <a href="MyServlet">MyServlet</a>
            </li>
            <li>
                <a href="http://localhost:8080/WebServlet/SecondServlet?onoma=Jack&age=30">SecondServlet</a>
            </li>
            <li>
                <a href="ListCustomerServlet">List of Customers (Servlet)</a>
            </li>
            <li>
                <a href="ListProductServlet">Products (Servlets + JSPs)</a>
            </li>
        </ul>

        <%
            String footerMessage = "This is footer of JSP page";
            out.print(footerMessage);
        %>

        <!--Declaration jsp tag-->
        <%!
            private java.time.LocalDateTime now = java.time.LocalDateTime.now();

            private void printMessage(JspWriter out) {
                int age = 20;
                String message = "Hello from Scriptlet!!!";
                message += " My age is " + age;
                message += ". today is :" + now;
                try {
                    out.print(message);
                } catch (Exception e) {

                }
            }
        %>

    </body>
</html>
