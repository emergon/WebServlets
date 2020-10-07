/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.servlet.product;

import emergon.service.ProductService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "DeleteProductServlet", urlPatterns = {"/product/deleteProduct"})
public class DeleteProductServlet extends HttpServlet {

    ProductService service = new ProductService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pcode = req.getParameter("id");
        String message = service.deleteProduct(pcode);
        String contextPath = req.getContextPath();
        if(message == null){
            //redirect to the List of Products page
            resp.sendRedirect(contextPath+"/ListProductServlet");
        }else{
            //Forward the request to the jsp page
            req.setAttribute("minima", message);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/errorPage.jsp");
            dispatcher.forward(req, resp);
            //resp.getWriter().print(message);
        }
        //send back the response
    }

    
}
