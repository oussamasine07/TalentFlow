package talentflow.filters.Authorization;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import talentflow.model.User;

import java.io.IOException;

@WebFilter("/offer/*")
public class IsRecruiter implements Filter {

    private HttpServletRequest httpReq;
    private HttpServletResponse httpRes;

    public void doFilter (ServletRequest req, ServletResponse res, FilterChain chain)
        throws ServletException, IOException
    {
        httpReq = (HttpServletRequest) req;
        httpRes = (HttpServletResponse) res;

        // get the session
        HttpSession session = httpReq.getSession();

        // get the role of authenticated user
        User user = (User) session.getAttribute("user");
        String authenticatedUserRole = user != null ? user.getRole() : "";

        String requestURI = httpReq.getRequestURI();

        if (requestURI.equals(httpReq.getContextPath() + "/offer")) {
            chain.doFilter(req, res);
            return;
        }

        if (user != null && !authenticatedUserRole.equals("recruteur")) {
            String referer = httpReq.getHeader("Referer");
            if ( referer != null ) {
                httpRes.sendRedirect(referer);
            } else {
                httpRes.sendRedirect(httpReq.getContextPath() + "/dashboard");
            }
        } else {
            chain.doFilter(req, res);
        }




    }

}
