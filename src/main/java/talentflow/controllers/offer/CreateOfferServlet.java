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

@WebServlet("/recruiter/offer/create")
public class CreateOfferServlet extends HttpServlet {

    OfferDAO offerDAO = null;
    RecruiterDAO recruiterDAO = null;
    public void init () {
        recruiterDAO = new RecruiterDAO();
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
        String offerDate = req.getParameter("datetime");
        HttpSession session = req.getSession();

        // get authenticated user
        User user = (User) session.getAttribute("user");

        // get recruiter
        Recruiter recruiter = recruiterDAO.getRecruiterByUserId(user.getId());
        Offer offer = new Offer(title, description, offerDate);

        offerDAO.addOffer(offer, recruiter);
        res.sendRedirect(req.getContextPath() + "/recruiter/offer/create");
    }
}
