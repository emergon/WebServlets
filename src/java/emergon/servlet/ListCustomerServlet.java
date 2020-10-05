package emergon.servlet;

import emergon.entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListCustomerServlet", urlPatterns = {"/ListCustomerServlet"})
public class ListCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> listOfCustomers = new ArrayList();
        listOfCustomers.add(new Customer(12, "Jack"));
        listOfCustomers.add(new Customer(25, "Mary"));
        listOfCustomers.add(new Customer(30, "Andy"));
        listOfCustomers.add(new Customer(35, "Peter"));
        
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>List Of Customer</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>List of Customers</h1>")
                .append("<table border='1'>");
        
        for(Customer c: listOfCustomers){
            builder.append("<tr>")
//                    .append("<td>").append(c.getCcode()).append("</td>")
                    .append("<td>").append(c.getCname()).append("</td>")
                    .append("</tr>");
        }
        
        builder.append("</table>")
                .append("</body>")
                .append("</html>");
        
        PrintWriter writer = resp.getWriter();
        writer.print(builder.toString());
    }

    
   
}
