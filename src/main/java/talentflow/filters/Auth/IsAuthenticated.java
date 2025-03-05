package talentflow.filters.Auth;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

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

    }

}
