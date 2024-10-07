package org.ifs.yapi.common;

import org.ifs.yapi.constant.Constant;
import org.ifs.yapi.pojo.resp.LoginUserInfo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        if ("/".equals(requestURI)
                || requestURI.startsWith("/user")
                || requestURI.startsWith("/assets/")
                || requestURI.startsWith("/css/")
                || requestURI.startsWith("/js/")
                || requestURI.startsWith("/element-ui/")) {
            filterChain.doFilter(request, response);
        } else {
            LoginUserInfo userInfo = (LoginUserInfo) request.getSession().getAttribute(Constant.SESSION_KEY_NAME);
            if (null == userInfo) {
               response.sendRedirect(request.getContextPath() + "/user/notLogin");
               return;
            }
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
