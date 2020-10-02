/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class SecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String onoma = request.getParameter("onoma");//get parameter from request with name = onoma
        String ageInString = request.getParameter("age");//get value from parameter request with name = age
        int age = Integer.parseInt(ageInString);
        response.setContentType("text/html");//This is a header in HTTP protocol. Tells the browser that this is html text.
        PrintWriter out = response.getWriter();//Get Writer from Response Object that will prepare the response.
        out.print("<h2>Your name is :");
        out.print(onoma);
        out.print("</h2>");
        out.print("<h2>Your age is : "+age+"</h2>");
        
    }

    
}
