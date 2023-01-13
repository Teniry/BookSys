package filter;



import pojo.Reader;
import service.impl.ReaderService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        HttpServletResponse servletResponse1 = (HttpServletResponse) servletResponse;
        String id= (String) httpServletRequest.getSession().getAttribute("rdID");
        if(id==null){
           servletResponse1.sendRedirect(((HttpServletRequest) servletRequest).getContextPath()+"/index.jsp");

        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
