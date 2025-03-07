package talentflow.dao;

import talentflow.model.Candidature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidatureDAO extends ConnectToDB {

    private static final String POSTULER_UNE_CANDIDAT  = "INSERT INTO candidatures\n" +
            "    (candidat_id, offre_id)\n" +
            "VALUES \n" +
            "    (?, ?);";

    private static final String CHECK_IF_ALREADY_EXISTS  = "SELECT * FROM candidatures\n" +
            "WHERE candidat_id = ? AND offre_id = ?;";

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

    public Candidature getCandidatureIfAlreadyexists (Candidature candidature) {
        Candidature foundCandidature = null;
        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(CHECK_IF_ALREADY_EXISTS);
        ){
            ps.setInt(1, candidature.getCandidat().getCandidatId());
            ps.setInt(2, candidature.getOffre().getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                foundCandidature = new Candidature( rs.getInt("id"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return foundCandidature;
    }

}
