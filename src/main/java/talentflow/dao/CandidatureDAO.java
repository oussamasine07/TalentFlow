package talentflow.dao;

import talentflow.model.Candidat;
import talentflow.model.Candidature;
import talentflow.model.Offer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidatureDAO extends ConnectToDB {

    private static final String POSTULER_UNE_CANDIDAT  = "INSERT INTO candidatures\n" +
            "    (candidat_id, offre_id)\n" +
            "VALUES \n" +
            "    (?, ?);";

    private static final String CHECK_IF_ALREADY_EXISTS  = "SELECT * FROM candidatures\n" +
            "WHERE candidat_id = ? AND offre_id = ?;";

    private static final String GET_DANDIDATES_BY_USER_ID = "SELECT\n" +
            "    offers.title,\n" +
            "    offers.offer_date,\n" +
            "    candidatures.id,\n" +
            "    candidatures.status,\n" +
            "    candidatures.is_canceled\n" +
            "FROM candidatures\n" +
            "inner join candidates\n" +
            "         on candidates.id = candidatures.candidat_id\n" +
            "INNER JOIN offers\n" +
            "         on offers.id = candidatures.offre_id\n" +
            "WHERE candidates.user_id = ?;";

    private static final String GET_CANDIDATURE_BY_ID = "SELECT\n" +
            "    candidatures.id,\n" +
            "    candidatures.status,\n" +
            "    candidatures.is_canceled,\n" +
            "    candidates.user_id\n" +
            "FROM candidatures\n" +
            "inner join candidates\n" +
            "         on candidates.id = candidatures.candidat_id\n" +
            "WHERE candidatures.id = ? AND candidates.user_id = ?;";

    private static final String DELETE_CANDIDATURE_BY_ID = "DELETE FROM candidatures WHERE id = ?;";

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

    public List<Candidature> getCandidatesByUserId ( int userId ) {
        List<Candidature> candidatures = new ArrayList<Candidature>();

        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(GET_DANDIDATES_BY_USER_ID);
        ){
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("id");
                String offerName = rs.getString("title");
                String offerDate = rs.getString("offer_date");
                String status = rs.getString("status");
                boolean isCanceled = rs.getBoolean("is_canceled");

                Offer offer = new Offer(offerName, offerDate);
                Candidature candidature = new Candidature(id, status, isCanceled, offer);
                candidatures.add(candidature);

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return candidatures;
    }

    public Candidature getCandidatureById ( int candidtatureId, int userId ) {
        Candidature foundCandidature = null;
        try (
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(GET_CANDIDATURE_BY_ID);
        ){
            ps.setInt(1, candidtatureId);
            ps.setInt(2, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String status = rs.getString("status");
                boolean isCanceled = rs.getBoolean("is_canceled");
                int candidateId = rs.getInt("user_id");
                Candidat candidate = new Candidat( candidateId );

                foundCandidature = new Candidature( id, status, isCanceled, candidate );
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return foundCandidature;
    }

    public void deleteCandidatureById ( int candidatureId ) {
        try (
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_CANDIDATURE_BY_ID);
        ){
            stmt.setInt( 1, candidatureId );
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

























