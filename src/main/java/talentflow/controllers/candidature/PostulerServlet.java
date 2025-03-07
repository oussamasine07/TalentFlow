package talentflow.controllers.candidature;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import talentflow.dao.CandidatDAO;
import talentflow.dao.CandidatureDAO;
import talentflow.dao.OfferDAO;
import talentflow.model.Candidat;
import talentflow.model.Candidature;
import talentflow.model.Offer;
import talentflow.model.User;

import java.io.IOException;

@WebServlet("/candidature/postuler")
public class PostulerServlet extends HttpServlet {

    private CandidatDAO candidatDAO = null;
    private OfferDAO offerDAO = null;
    private CandidatureDAO candidatureDAO = null;
    public void init(){
        offerDAO = new OfferDAO();
        candidatDAO = new CandidatDAO();
        candidatureDAO = new CandidatureDAO();
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // get authenticated user
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        // get candidate
        Candidat candidat = candidatDAO.getCandidatByUserId(user.getId());
        System.out.println(candidat.getCandidatId());
        // get offer
        int offerId = Integer.parseInt(request.getParameter("offerId"));
        Offer offer = offerDAO.getOfferById(offerId);

        Candidature candidature = new Candidature(candidat, offer);

        candidatureDAO.postuler(candidature);

        session.setAttribute("success", "postulation success");
        // redirect
        response.sendRedirect(request.getContextPath() + "/offer");
    }

    protected void doGet (HttpServletRequest request, HttpServlet response )
            throws ServletException, IOException
    {

    }
}

