package talentflow.controllers.offer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import talentflow.dao.OfferDAO;
import talentflow.dao.RecruiterDAO;
import talentflow.model.Offer;
import talentflow.model.Recruiter;
import talentflow.model.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/offer")
public class IndexOfferServlet extends HttpServlet {
    OfferDAO offerDAO = null;
    public void init () {
        offerDAO = new OfferDAO();
    }

    protected void doGet (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {

        List<Offer> offers = offerDAO.getListOfOffers();
        req.setAttribute("offers", offers);
        RequestDispatcher rs = req.getRequestDispatcher("/views/offer/index.jsp");
        rs.forward(req, res);
    }
}
