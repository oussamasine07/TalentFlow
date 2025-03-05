package talentflow.controllers.offer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import talentflow.dao.OfferDAO;

import java.io.IOException;

@WebServlet("/offer/create")
public class CreateOfferServlet extends HttpServlet {

    OfferDAO offerDAO = null;
    public void init () {
        offerDAO = new OfferDAO();
    }

    protected void doGet (HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
        RequestDispatcher rs = req.getRequestDispatcher("/views/offer/create.jsp"); // todo create views folder
        rs.forward(req, res);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String offer_date = req.getParameter("datetime");

        // get recruiter


    }
}
