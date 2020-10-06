package emergon.servlet;

import emergon.entity.Customer;
import emergon.service.CustomerService;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListCustomerServlet", urlPatterns = {"/ListCustomerServlet"})
public class ListCustomerServlet extends HttpServlet {

    private CustomerService service = new CustomerService();
    private LocalDateTime now = LocalDateTime.now();

    private void myResponse(HttpServletResponse resp) throws IOException {
        List<Customer> listOfCustomers = service.getCustomers();
        System.out.println("ListCustomerServlet doGet method just called.....");
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>List Of Customer</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>List of Customers</h1>")
                .append("<a href='customer/insert'>").append("New Customer").append("</a>")
                .append("<table border='1'>");

        for (Customer c : listOfCustomers) {
            builder.append("<tr>")
                    .append("<td>").append(c.getCcode()).append("</td>")
                    .append("<td>").append(c.getCname()).append("</td>")
                    .append("</tr>");
        }

        builder.append("</table>")
                .append("</body>")
                .append("</html>");
        PrintWriter writer = resp.getWriter();
        writer.print(builder.toString());
    }

    @Override
    public void init() throws ServletException {
        System.out.println("ListCustomerServlet just Created!!!!!!!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        myResponse(resp);

    }

}
