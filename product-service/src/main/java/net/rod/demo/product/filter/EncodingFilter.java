package net.rod.demo.product.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * just a demo purpose
 *
 * @author Rod ,have fun with coding
 * @date 2021/2/3 21:21
 */

@WebFilter(filterName = "encoding", urlPatterns = "/*")
public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before encoding filter! ");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("after encoding filter! ");
    }
}
