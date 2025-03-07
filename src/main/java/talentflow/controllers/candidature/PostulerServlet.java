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
import java.util.HashMap;
import java.util.Map;

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

        Map<String, String> message = new HashMap<String, String>();

        if ( !user.getRole().equals("condidat")) {
            message.put("type", "error");
            message.put("message", "Unauthorized action");
            session.setAttribute("message", message);
            System.out.println("Unauthorized action");
            response.sendRedirect(request.getContextPath() + "/offer");
        } else {
            // get candidate
            Candidat candidat = candidatDAO.getCandidatByUserId(user.getId());
            System.out.println(candidat.getCandidatId());
            // get offer
            int offerId = Integer.parseInt(request.getParameter("offerId"));
            Offer offer = offerDAO.getOfferById(offerId);

            Candidature candidature = new Candidature(candidat, offer);
            Candidature foundCandidature = candidatureDAO.getCandidatureIfAlreadyexists(candidature);

            if (foundCandidature != null ) {
                message.put("type", "error");
                message.put("message", "you already posted for this offer");
                session.setAttribute("message", message);
                System.out.println("Unauthorized action");
                response.sendRedirect(request.getContextPath() + "/offer");
            } else {
                candidatureDAO.postuler(candidature);
                System.out.println("postulation success");
                message.put("type", "success");
                message.put("message", "postulation success");
                session.setAttribute("message", message);
                response.sendRedirect(request.getContextPath() + "/offer");
            }
        }
    }

    protected void doGet (HttpServletRequest request, HttpServlet response )
            throws ServletException, IOException
    {

    }
}

