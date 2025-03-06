package talentflow.dao;

import talentflow.model.Offer;
import talentflow.model.Recruiter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OfferDAO extends ConnectToDB {
    private static final String INSERT_INTO_OFFERS = "INSERT INTO offers (title, description, offer_date, recruiter_id) VALUES (?, ?, ?,?);";
    private static final String SELECT_ALL_OFFERS_BY_RECRUITER_ID = "SELECT * FROM offers WHERE recruiter_id = ?";

    public OfferDAO (){}

    public void addOffer(Offer offer, Recruiter recruiter){
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(INSERT_INTO_OFFERS);
        ){
            stmt.setString(1,offer.getTitle());
            stmt.setString(2,offer.getDescription());
            stmt.setString(3,offer.getofferDate());
            stmt.setInt(4, recruiter.getRecruiterId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Offer> getListOfRecruiterOffers (int recruiterId) {
        List<Offer> offers = new ArrayList<>();

        try (
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_OFFERS_BY_RECRUITER_ID);
        ){
            stmt.setInt(1, recruiterId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String offerDate = rs.getString("offer_date");
                offers.add(new Offer(id, title, description, offerDate));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return  offers;
    }

}



