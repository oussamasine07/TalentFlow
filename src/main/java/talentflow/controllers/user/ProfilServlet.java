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
import talentflow.model.Recruiter;
import talentflow.model.User;

import java.io.IOException;

@WebServlet("/profile")
public class ProfilServlet extends HttpServlet {

    CandiatDAO candiatDAO = null;
    RecruiterDAO recruiterDAO = null;

    public void init () {
        recruiterDAO = new RecruiterDAO();
        candiatDAO = new CandiatDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println("user id is " + user.getId());

        // get candidat
        User userType = user.getRole().equals("recruteur") ? recruiterDAO.getRecruiterByUserId(user.getId()) : candiatDAO.getCandidatByUserId(user.getId());

        request.setAttribute("userType", userType);
        System.out.println("firstname is " + user.getFirstName());
        RequestDispatcher rs = request.getRequestDispatcher("/views/user/profile.jsp");
        rs.forward(request, response);
    }
}
