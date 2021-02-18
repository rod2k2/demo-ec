package net.rod.demo.product.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Rod ,have fun with coding
 * @date 2021/1/19
 */

@WebFilter(filterName = "authFilter",urlPatterns = "/*")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before AuthFilter !!! ");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("after  AuthFilter !!! ");
    }
}