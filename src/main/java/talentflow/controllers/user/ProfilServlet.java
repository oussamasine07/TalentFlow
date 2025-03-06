package talentflow.controllers.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import talentflow.model.Candidat;
import talentflow.model.User;

import java.io.IOException;

@WebServlet("/profil")
public class ProfilServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Candidat candidat = (Candidat) session.getAttribute("candidat");

        if (candidat == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        request.setAttribute("candidat", candidat);
        request.getRequestDispatcher("profil.jsp").forward(request, response);
    }



    }

