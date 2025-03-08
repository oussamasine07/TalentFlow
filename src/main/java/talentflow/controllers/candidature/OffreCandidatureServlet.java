package talentflow.controllers.candidature;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import talentflow.dao.CandidatureDAO;
import talentflow.dao.OfferDAO;
import talentflow.model.Candidature;

import java.io.IOException;
import java.util.List;

@WebServlet("/offer/mes-offer/candidatures")
public class OffreCandidatureServlet  extends HttpServlet {

    CandidatureDAO candidatureDAO = null;
    OfferDAO offerDAO = null;

    public void init(){
        candidatureDAO = new CandidatureDAO();
        offerDAO = new OfferDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int offreId = Integer.parseInt(req.getParameter("id"));

        List<Candidature> candidatures = candidatureDAO.getCandidatureByOfferId(offreId);


        req.setAttribute("candidatures", candidatures);

        RequestDispatcher rd = req.getRequestDispatcher("/views/candidature/recruiter-candidatures.jsp");
        rd.forward(req, resp);

    }
}
