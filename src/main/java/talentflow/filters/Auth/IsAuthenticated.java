package talentflow.filters.Auth;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class IsAuthenticated implements Filter {

    private HttpServletRequest httpReq;
    private HttpServletResponse httpRes;

    private final String[] protectedURIs = {
         "/dashboard",
         "/profile",
    };

    @Override
    public void doFilter (ServletRequest req, ServletResponse res, FilterChain chain)
        throws ServletException, IOException
    {
        httpReq = (HttpServletRequest) req;
        httpRes = (HttpServletResponse) res;

        HttpSession session = httpReq.getSession(false);
        boolean isLoggedInUser = (session != null && session.getAttribute("user") != null);

        String loginURI = httpReq.getContextPath() + "/auth/login";
        String registerURI = httpReq.getContextPath() + "/auth/register";

        boolean isAuthRequest = (httpReq.getRequestURI().equals(loginURI) || httpReq.getRequestURI().equals(registerURI));

        boolean isAuthPage = (httpReq.getRequestURI().endsWith("/login") || httpReq.getRequestURI().endsWith("/register"));

        // start the check
        if (isLoggedInUser && (isAuthRequest || isAuthPage)) {
            httpRes.sendRedirect(httpReq.getContextPath() + "/dashboard");
        }
        else if (!isLoggedInUser && isLoginRequired()) {
            httpRes.sendRedirect(httpReq.getContextPath() + "/auth/login");
        }
        else {
            chain.doFilter(req, res);
        }

    }

    boolean isLoginRequired () {
        String requestURL = httpReq.getRequestURL().toString();
        for (String protectedUrl : protectedURIs) {
            if (requestURL.contains(protectedUrl)) {
                return true;
            }
        }
        return false;
    }

}























