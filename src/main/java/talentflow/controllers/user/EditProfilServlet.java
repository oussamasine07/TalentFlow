package talentflow.controllers.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import talentflow.model.Candidat;

import java.io.IOException;

@WebServlet ("/edit-profil")
public class EditProfilServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Candidat candidat = (Candidat) session.getAttribute("candidat");


        if (candidat == null) {
        }
            response.sendRedirect("login.jsp");
            return;

        }
}
