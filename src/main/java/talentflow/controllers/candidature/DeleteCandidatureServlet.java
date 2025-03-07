package talentflow.controllers.candidature;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import talentflow.dao.CandidatureDAO;
import talentflow.model.Candidature;
import talentflow.model.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/candidature/delete")
public class DeleteCandidatureServlet extends HttpServlet {

    CandidatureDAO candidatureDAO = null;
    public void init () {
        candidatureDAO = new CandidatureDAO();
    }

    protected void doPost (HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
        int candidatureId = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        Candidature candidature = candidatureDAO.getCandidatureById(candidatureId, user.getId());

        if ( candidature == null ) {

            Map<String, String> message = new HashMap<>();
            message.put("type", "error");
            message.put("message", "you're not authorized");
            System.out.println(message);
            res.sendRedirect(req.getContextPath() + "/candidature/mes-candidatures");

        } else {

            // delete from data base
            candidatureDAO.deleteCandidatureById( candidatureId );
            res.sendRedirect(req.getContextPath() + "/candidature/mes-candidatures");

        }
    }

}
