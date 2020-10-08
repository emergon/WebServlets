/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.servlet.product;

import emergon.entity.Product;
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
@WebServlet(name = "EditProductServlet", urlPatterns = {"/product/editProduct"})
public class EditProductServlet extends HttpServlet {

    ProductService service = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //show Product form
        //Selected Product will fill the form
        //product/editProduct?id=${p.pcode}
        String id = req.getParameter("id");
        Product product = service.findProduct(id);
        req.setAttribute("proion", product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/product/productEditForm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get the parameters from the request
        //Save the object to the database
        //redirect to List of Products
        String pcode = req.getParameter("pcode");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        boolean result = service.updateProduct(pcode, description, price);//Store Product in DB

        String message;
        if (result==true) {
            message = "Product updated successfully!";
        }else{
            message = "Product wasn't updated!";
        }
        req.setAttribute("minima", message);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/ListProductServlet");
//        dispatcher.forward(req, resp);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/ListProductServlet?minima="+message);
    }
}
