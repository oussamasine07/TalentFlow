package talentflow.filters.Authorization;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import talentflow.model.User;

import java.io.IOException;

@WebFilter("/candidature/*")
public class IsCandidate implements Filter {

    private HttpServletRequest httpReq;
    private HttpServletResponse httpRes;

    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain)
        throws ServletException, IOException
    {

        httpReq = (HttpServletRequest) request;
        httpRes = (HttpServletResponse) response;

        HttpSession session = httpReq.getSession();

        User user = (User) session.getAttribute("user");
        String authenticatedUserRole = user != null ? user.getRole() : "";

        String requestURI = httpReq.getRequestURI();

        if (requestURI.equals(httpReq.getContextPath() + "/candidature/update-status")) {
            chain.doFilter(request, response);
            return;
        }

        if (user != null && !authenticatedUserRole.equals("condidat")) {
            String referer = httpReq.getHeader("Referer");
            if ( referer != null ) {
                httpRes.sendRedirect(referer);
            } else {
                httpRes.sendRedirect(httpReq.getContextPath() + "/dashboard");
            }
        } else {
            chain.doFilter(request, response);
        }



    }
}





















