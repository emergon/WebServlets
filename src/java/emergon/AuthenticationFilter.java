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
        System.out.println("username:"+username);
        
        String loginPage = "login.jsp";
        String loginServlet = "LoginServlet";
        String requestUri = httpRequest.getRequestURI();
        System.out.println("requestUri:"+requestUri);
        
        boolean isUsernameNull = (username ==null);
        System.out.println("isUsernameNull:"+isUsernameNull);
        boolean isUserTryingToLogin = requestUri.contains(loginPage) || requestUri.contains(loginServlet);
        System.out.println("isUserTryingToLogin:"+isUserTryingToLogin);
        
        if(isUsernameNull && !isUserTryingToLogin){//username=null && url=/products/list
            HttpServletResponse resp = (HttpServletResponse) response;
            String contextPath = httpRequest.getContextPath();
            resp.sendRedirect(contextPath+"/login.jsp");
        }else{
            chain.doFilter(request, response);
        }
        
    }
    
    
}
