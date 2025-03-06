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

@WebServlet("/recruiter/offer/update")
public class UpdateOfferServlet extends HttpServlet {
    OfferDAO offerDAO = null;
    RecruiterDAO recruiterDAO = null;

    public void init () {
        recruiterDAO = new RecruiterDAO();
        offerDAO = new OfferDAO();
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
        int id = Integer.parseInt(req.getParameter("id"));

        Offer offer = offerDAO.getOfferById(id);
        req.setAttribute("offer", offer);
        RequestDispatcher rs = req.getRequestDispatcher("/views/offer/edit.jsp");
        rs.forward(req, res);
    }


    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {

        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String offerDate = req.getParameter("datetime");
        HttpSession session = req.getSession();

        // get authenticated user
        User user = (User) session.getAttribute("user");

        // get recruiter
        Recruiter recruiter = recruiterDAO.getRecruiterByUserId(user.getId());

        Offer offer = offerDAO.getOfferById(id);

        if (recruiter.getRecruiterId() != offer.getRecruiter().getRecruiterId()) {
            System.out.println("unauthorized action");
            res.sendRedirect(req.getContextPath() + "/recruiter/offer/update?id=" + offer.getId());
        } else {
            System.out.println("updated succefully");
            Offer updatedOffer = new Offer(id, title, description, offerDate);
            // update
            offerDAO.updateOffer( updatedOffer );
            res.sendRedirect(req.getContextPath() + "/recruiter/offer");
        }
    }

}
