package talentflow.controllers.offer;

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

@WebServlet("/offer/delete")
public class DeleteOfferServlet extends HttpServlet {
    OfferDAO offerDAO = null;
    RecruiterDAO recruiterDAO = null;
    public void init () {
        recruiterDAO = new RecruiterDAO();
        offerDAO = new OfferDAO();
    }

    protected void doPost (HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
        int id = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();

        // get authenticated user
        User user = (User) session.getAttribute("user");

        // get recruiter
        Recruiter recruiter = recruiterDAO.getRecruiterByUserId(user.getId());

        Offer offer = offerDAO.getOfferById(id);

        if (recruiter.getRecruiterId() != offer.getRecruiter().getRecruiterId()) {
            System.out.println("unauthorized action");
            res.sendRedirect(req.getContextPath() + "/offer/update?id=" + offer.getId());
        } else {
            // update
            offerDAO.deleteOffer( id );
            res.sendRedirect(req.getContextPath() + "/offer/my-offers");
        }
    }
}
