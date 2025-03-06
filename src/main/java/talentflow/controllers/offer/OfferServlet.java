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
public class OfferServlet extends HttpServlet {

    OfferDAO offerDAO = null;
    RecruiterDAO recruiterDAO = null;
    public void init () {
        recruiterDAO = new RecruiterDAO();
        offerDAO = new OfferDAO();
    }

    protected void doGet (HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        // get authenticated user
        User user = (User) session.getAttribute("user");
        // get recruiter
        Recruiter recruiter = recruiterDAO.getRecruiterByUserId(user.getId());

        List<Offer> offers = offerDAO.getListOfRecruiterOffers(recruiter.getRecruiterId());
        offers.forEach(offer -> System.out.println(offer.getTitle()));
        req.setAttribute("offers", offers);
        RequestDispatcher rs = req.getRequestDispatcher("/views/offer/index.jsp");
        rs.forward(req, res);
    }

}
