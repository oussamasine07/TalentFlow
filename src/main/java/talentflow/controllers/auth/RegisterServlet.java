package talentflow.controllers.auth;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.*;
import talentflow.dao.ConnectToDB;
import talentflow.dto.RegisterDTO;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/auth/register")
public class RegisterServlet extends HttpServlet {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public void init () {}

    protected void doGet (HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {

        ConnectToDB connectToDB = new ConnectToDB();
        connectToDB.getConnection();

        RequestDispatcher rs = req.getRequestDispatcher("/views/auth/register.jsp");
        rs.forward(req, res);
    }

    protected void doPost (HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String role = req.getParameter("role");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        RegisterDTO registerDTO = new RegisterDTO(firstName, lastName, email, role, password, confirmPassword);


        Set<ConstraintViolation<RegisterDTO>> violations = validator.validate(registerDTO);
        HttpSession session = req.getSession();
        Map<String, String> errors = new HashMap<>();

        if (!violations.isEmpty()) {
            for (ConstraintViolation<RegisterDTO> violation : violations) {
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            }

            session.setAttribute("errors", errors);
            session.setAttribute("old", registerDTO);

            res.sendRedirect(req.getContextPath() + "/auth/register");

        } else {

            res.sendRedirect(req.getContextPath() + "/auth/register"); // todo add login route
        }

    }

}





























