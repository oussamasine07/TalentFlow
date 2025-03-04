package talentflow.controllers.auth;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import talentflow.dao.ConnectToDB;

import java.io.IOException;

@WebServlet("/auth/register")
public class RegisterServlet extends HttpServlet {

    public void init () {}

    protected void doGet (HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {

        ConnectToDB connectToDB = new ConnectToDB();
        connectToDB.getConnection();

        RequestDispatcher rs = req.getRequestDispatcher("/views/auth/register.jsp");
        rs.forward(req, res);
    }
}
