package talentflow.controllers.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import talentflow.dao.CandiatDAO;
import talentflow.model.Candidat;
import talentflow.model.User;

import java.io.IOException;

@WebServlet("/profile")
public class ProfilServlet extends HttpServlet {

    CandiatDAO candiatDAO = null;

    public void init () {
        candiatDAO = new CandiatDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(user);

        // get candidat
        User candidat = candiatDAO.getCandidatByUserId(user.getId());

        request.setAttribute("candidat", candidat);
        System.out.println(candidat.getFirstName());
        RequestDispatcher rs = request.getRequestDispatcher("/views/user/profile.jsp");
        rs.forward(request, response);
    }
}
