package emergon;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class MyServlet extends HttpServlet {

   
    @Override//accepts GET Requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter myWriter = response.getWriter();
        myWriter.print("<h1>Hello I am Servlet MyServlet. Responding From doGet method</h1>");
        myWriter.print("<br/>");
        myWriter.print(LocalDateTime.now());
    }

    
    @Override//accepts POST Requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
