package talentflow.controllers.candidature;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import talentflow.dao.CandidatureDAO;

import java.io.IOException;

@WebServlet("/candidature/update-status")
public class UpdateCandidatureStatusServlet extends HttpServlet {

    CandidatureDAO candidatureDAO = null;
    public void init() {
        candidatureDAO = new CandidatureDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int candidatureId = Integer.parseInt(req.getParameter("id"));

        String status = req.getParameter("status");

        candidatureDAO.updatCandidatureStatusById(candidatureId,status);
        resp.sendRedirect(req.getContextPath()+"/offer/my-offers");


    }
}
