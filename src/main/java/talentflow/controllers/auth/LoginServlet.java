package talentflow.controllers.auth;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {

    public void init () {}

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
        RequestDispatcher rs = req.getRequestDispatcher("/views/auth/login.jsp");
        rs.forward(req, res);
    }

}
