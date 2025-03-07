package talentflow.dao;

import talentflow.model.Candidat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidatDAO extends ConnectToDB {

    private static final String GET_CANDIDAT_BY_USER_ID = "SELECT * FROM candidates WHERE user_id=?";

    public CandidatDAO() {}

    public Candidat getCandidatByUserId ( int userId ) {
        Candidat candidat = null;
        try (
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(GET_CANDIDAT_BY_USER_ID);
        ){
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String phone = rs.getString("phone");
                String diplome = rs.getString("diplome");
                String cv = rs.getString("cv");
                candidat = new Candidat(id, phone, diplome, cv);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return candidat;
    }
}
