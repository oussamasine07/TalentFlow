package talentflow.dao;

import talentflow.dto.LoginDTO;
import talentflow.dto.RegisterDTO;
import talentflow.model.Candidat;
import talentflow.model.Recruiter;
import talentflow.model.User;

import java.sql.*;

public class UserDAO extends ConnectToDB {

    private static final String GET_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?;";
    private static final String INSERT_INTO_USERS = "INSERT INTO users (firstName, lastName, email, password, role) VALUES (?, ?, ?, ?, ?);";
    private static final String ADD_RECRUITER = "INSERT INTO recruiters (user_id) values (?);";
    private static final String ADD_CANDIDAT = "INSERT INTO candidates (user_id) values (?);";

    public UserDAO () {}

    public void registerUser (RegisterDTO register) {

        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(INSERT_INTO_USERS, Statement.RETURN_GENERATED_KEYS);
        ){

            stmt.setString(1, register.getFirstName());
            stmt.setString(2, register.getFirstName());
            stmt.setString(3, register.getEmail());
            stmt.setString(4, register.getPassword());
            stmt.setString(5, register.getRole());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {  // Ensure there's a result before accessing it
                int userId = rs.getInt(1); // Typically, the first column returned is the generated id
                if ("recruteur".equals(register.getRole())) addRecruiter(userId);
                if ("condidat".equals(register.getRole())) addCandidat(userId);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void addRecruiter ( int recruiterId ) {
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(ADD_RECRUITER);
        ){
            stmt.setInt(1, recruiterId);
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCandidat ( int candidatId ) {
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(ADD_CANDIDAT);
        ){
            stmt.setInt(1, candidatId);
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserByEmail ( String email ) {
        User user = null;

        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(GET_USER_BY_EMAIL);
        ){
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String userEmail = rs.getString("email");
                String role = rs.getString("role");
                user = role.equals("recruteur") ? new Recruiter(userEmail) : new Candidat(userEmail);
            }
        }
        catch ( SQLException e ){
            e.printStackTrace();
        }

        return user;

    }

    public User authenticateByEmail (String email) {
        User user = null;

        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(GET_USER_BY_EMAIL);
        ){
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String userEmail = rs.getString("email");
                String role = rs.getString("role");
                String password = rs.getString("password");

                user = role.equals("recruteur") ?
                        new Recruiter(id, firstName, lastName, userEmail, role, password) :
                        new Candidat(id, firstName, lastName, userEmail, role, password);
            }
        }
        catch ( SQLException e ){
            e.printStackTrace();
        }

        return user;
    }

}
