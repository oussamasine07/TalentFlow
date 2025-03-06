package talentflow.controllers.offer;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import talentflow.dao.OfferDAO;
import talentflow.dao.RecruiterDAO;

@WebServlet("/offer/update")
public class UpdateOfferServlet extends HttpServlet {
    OfferDAO offerDAO = null;
    RecruiterDAO recruiterDAO = null;
    public void init () {
        recruiterDAO = new RecruiterDAO();
        offerDAO = new OfferDAO();
    }
    public void doGet(){

    }
}
