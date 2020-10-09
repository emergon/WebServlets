package emergon;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //Transform request to httpServletRequest
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        //Check if session has Attribute username
        HttpSession session = httpRequest.getSession();
        String username = (String) session.getAttribute("username");
        String loginPage = "login.jsp";
        String uri = httpRequest.getRequestURI();
        if(username != null || (uri.contains(loginPage))){//username exists. User is logged in.
            chain.doFilter(request, response);
        } else{//username is null. User is not logged in.
            HttpServletResponse resp = (HttpServletResponse) response;
            String contextPath = httpRequest.getContextPath();
            resp.sendRedirect(contextPath+"/login.jsp");
        }
        
    }
    
    
}
