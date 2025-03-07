package talentflow.dao;

import talentflow.model.Candidature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CandidatureDAO extends ConnectToDB {

    private static final String POSTULER_UNE_CANDIDAT  = "INSERT INTO candidatures\n" +
            "    (candidat_id, offre_id)\n" +
            "VALUES \n" +
            "    (?, ?);";

    public CandidatureDAO(){}

    public void postuler (Candidature candidature) {
        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(POSTULER_UNE_CANDIDAT);
        ){
            ps.setInt(1, candidature.getCandidat().getCandidatId());
            ps.setInt(2, candidature.getOffre().getId());

            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
