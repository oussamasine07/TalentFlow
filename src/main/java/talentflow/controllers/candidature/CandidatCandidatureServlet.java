package talentflow.controllers.candidature;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import talentflow.dao.CandidatDAO;
import talentflow.dao.CandidatureDAO;
import talentflow.model.Candidat;
import talentflow.model.Candidature;
import talentflow.model.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/candidature/mes-candidatures")
public class CandidatCandidatureServlet extends HttpServlet {

    CandidatDAO candidatDAO = null;
    CandidatureDAO candidatureDAO = null;
    public void init () {
        candidatureDAO = new CandidatureDAO();
        candidatDAO = new CandidatDAO();
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        // auth user
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        // candidat
        Candidat candidat = candidatDAO.getCandidatByUserId(user.getId());
        List<Candidature> candidatures = candidatureDAO.getCandidatesByUserId(user.getId());
        req.setAttribute("candidatures", candidatures);
        System.out.println(candidatures.get(0).getOffre());

        RequestDispatcher rd = req.getRequestDispatcher("/views/candidature/mes-candidatures.jsp");
        rd.forward(req, res);

    }


}
