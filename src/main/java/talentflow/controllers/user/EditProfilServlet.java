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
import talentflow.dao.UserDAO;
import talentflow.model.Candidat;
import talentflow.model.Recruiter;
import talentflow.model.User;

import java.awt.datatransfer.DataFlavor;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {
        "/edit-profile",
        "/edit-profile/update-user",
        "/edit-profile/update-candidat",
        "/edit-profile/update-recruiter",
        "/edit-profile/delete"
})
public class EditProfilServlet extends HttpServlet {

    CandiatDAO candiatDAO = null;
    RecruiterDAO recruiterDAO = null;
    UserDAO userDAO = null;

    public void init () {
        recruiterDAO = new RecruiterDAO();
        candiatDAO = new CandiatDAO();
        userDAO = new UserDAO();
    }

    protected void doPost (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        doGet(req, res);
    }

    protected void doGet (HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {

        String action = req.getServletPath();

        System.out.println(action);

        switch (action) {
            case "/edit-profile":
                getEditProfile(req, res);
                break;
            case "/edit-profile/update-user":
                updateUser(req, res);
                break;
            case "/edit-profile/update-candidat":
                updateCandidat(req, res);
                break;
            case "/edit-profile/update-recruiter":
                updateRecruiter(req, res);
                break;
            case "/edit-profile/delete":
                deleteProfile(req, res);
                break;

        }


    }

    private void getEditProfile (HttpServletRequest req, HttpServletResponse res)
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

    private void updateUser (HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");

        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");
        User updatedUser = user.getRole().equals("recruteur") ?
                                new Recruiter(user.getId(), firstName, lastName, email, "")
                                : new Candidat(user.getId(), firstName, lastName, email, "");

        userDAO.updateUserById(updatedUser);

        res.sendRedirect(req.getContextPath() + "/edit-profile");
    }

    private void updateRecruiter (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        String company = req.getParameter("company");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");
        User recruiter = new Recruiter(user.getId(), company, phone, address, "");
        recruiterDAO.updateRecruiterByUserId(recruiter);
        res.sendRedirect(req.getContextPath() + "/edit-profile");
    }

    private void updateCandidat (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {

        String phone = req.getParameter("phone");
        String diploma = req.getParameter("diploma");

        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");
        User candidat =  new Candidat(user.getId(), diploma, phone, "", "");
        candiatDAO.updateCandidatByUserId(candidat);
        res.sendRedirect(req.getContextPath() + "/edit-profile");
    }

    private void deleteProfile (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        userDAO.deleteUserById(user.getId());

        session.invalidate();
        res.sendRedirect(req.getContextPath() + "/auth/login");
    }


}
