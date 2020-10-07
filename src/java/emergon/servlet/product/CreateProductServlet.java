package emergon.servlet.product;

import emergon.service.ProductService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateProductServlet", urlPatterns = {"/product/create"})
public class CreateProductServlet extends HttpServlet {

    ProductService service = new ProductService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productCreateForm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        service.createProduct(description, price);//Store Product in DB
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/ListProductServlet");
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/ListProductServlet");
//        dispatcher.forward(req, resp);
    }

    
    
}
