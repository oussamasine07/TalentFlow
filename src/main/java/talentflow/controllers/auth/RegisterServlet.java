package talentflow.controllers.auth;

import com.password4j.BcryptFunction;
import com.password4j.Hash;
import com.password4j.Password;
import com.password4j.types.Bcrypt;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.*;
import talentflow.dao.ConnectToDB;
import talentflow.dao.UserDAO;
import talentflow.dto.RegisterDTO;
import talentflow.model.User;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/auth/register")
public class RegisterServlet extends HttpServlet {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    private UserDAO userDAO = null;
    public void init () {
        userDAO = new UserDAO();
    }

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

        User user = null;

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
            user = userDAO.getUserByEmail(registerDTO.getEmail());
            if (user != null ) {
                session.setAttribute("errorUser", "this email is already taken");
                res.sendRedirect(req.getContextPath() + "/auth/register");
            } else {
                // hash password
                BcryptFunction bcrypt = BcryptFunction.getInstance(Bcrypt.B, 12);
                Hash hash = Password.hash(registerDTO.getPassword())
                        .addPepper("somethignrealyhard")
                        .with(bcrypt);
                registerDTO.setPassword(hash.getResult());
                userDAO.registerUser( registerDTO );
                session.setAttribute("registerSuccess", "Register success, Please login");
                res.sendRedirect(req.getContextPath() + "/auth/register");// todo add login route
            }

        }

    }

}





























