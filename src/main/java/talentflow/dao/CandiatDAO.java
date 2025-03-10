package talentflow.dao;

import talentflow.model.Candidat;
import talentflow.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandiatDAO extends ConnectToDB {

    private static final String GET_CANDIDAT_BY_USER_ID = "select * from candidates where user_id=?";
    private static final String UPDATE_CANDIDATE_BY_USER_ID = "UPDATE candidates\n" +
            "    SET phone = ?,\n" +
            "        diplome = ?\n" +
            "WHERE user_id = ?;";

    public CandiatDAO() {}

    public Candidat getCandidatByUserId (int userId) {
        Candidat candidat = null;

        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(GET_CANDIDAT_BY_USER_ID);
        ){
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String phone = rs.getString("phone");
                String diplome = rs.getString("diplome");

                candidat = new Candidat(phone, diplome);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return candidat;
    }

    public void updateCandidatByUserId (User candidate) {
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(UPDATE_CANDIDATE_BY_USER_ID);
        ){
            stmt.setString(1, candidate.getFirstName());
            stmt.setString(2, candidate.getLastName());
            stmt.setInt(3, candidate.getId());

            stmt.executeUpdate();
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

}
