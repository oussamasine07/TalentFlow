package talentflow.controllers.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import talentflow.dao.CandiatDAO;
import talentflow.dao.RecruiterDAO;
import talentflow.model.Candidat;
import talentflow.model.User;

import java.awt.datatransfer.DataFlavor;
import java.io.IOException;

@WebServlet ("/edit-profile")
public class EditProfilServlet extends HttpServlet {

    CandiatDAO candiatDAO = null;
    RecruiterDAO recruiterDAO = null;

    public void init () {
        recruiterDAO = new RecruiterDAO();
        candiatDAO = new CandiatDAO();
    }

    protected void doGet (HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        // get candidat
        User userType = user.getRole().equals("recruteur") ? recruiterDAO.getRecruiterByUserId(user.getId()) : candiatDAO.getCandidatByUserId(user.getId());

        req.setAttribute("userType", userType);

        RequestDispatcher rd = req.getRequestDispatcher("/views/user/edit-profile.jsp");
        rd.forward(req, res);
    }


}
