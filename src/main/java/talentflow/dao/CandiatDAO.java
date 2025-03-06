package talentflow.dao;

import talentflow.model.Candidat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandiatDAO extends ConnectToDB {

    private static final String GET_CANDIDAT_BY_USER_ID = "select * from candidates where user_id=?";

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

}
