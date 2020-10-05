package emergon.servlet;

import emergon.service.CustomerService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateCustomerServlet", urlPatterns = {"/customer/insert"})//this url is after contextPath
public class CreateCustomerServlet extends HttpServlet {

    private CustomerService service = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();//WebServlet
        String actionURL = contextPath + "/customer/insert";
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Create Customer</title>")
                .append("</head>")
                .append("<body>");
        builder.append("<h1>New Customer</h1>")
                .append("<form action= '").append(actionURL).append("' method='POST'>")
                .append("Cname:").append("<input type='text' name='cname'>")
                .append("<br/>")
                .append("<br/>")
                .append("<input type='submit' value='Submit'>")
                .append("</form>");
        builder.append("</body>")
                .append("</html>");
                
        PrintWriter out = resp.getWriter();
        out.print(builder);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cname = req.getParameter("cname");
        service.createCustomer(cname);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/ListCustomerServlet");
    }
    
    

    
}
