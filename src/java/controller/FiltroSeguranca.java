package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Neto
 */
public class FiltroSeguranca implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");  
        String contextPath = req.getContextPath();        
        if (req.getRequestURI().endsWith("/index.xhtml") || req.getRequestURI().contains("javax.faces.resource")){
            chain.doFilter(request, response);
        }else{
            HttpSession sessao = ((HttpServletRequest)request).getSession();            
            if (sessao.getAttribute("sys_user") == null)
               ((HttpServletResponse)response).sendRedirect(contextPath+"/faces/index.xhtml");
            else{
               chain.doFilter(request,response);
            }
        }
    }

    @Override
    public void destroy() {
        
    }
}
