package talentflow.dao;

import talentflow.model.Offer;
import talentflow.model.Recruiter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OfferDAO extends ConnectToDB {
        private static final String INSERT_INTO_OFFERS = "INSERT INTO offers (title, description, date, recruiter_id) VALUES (?, ?, ?,?);";
        private static final String SELECT_ALL_OFFERS = "SELECT * FROM offers";
        private static final String DELET_OFFERS_BY_ID = "DELETE FROM offers where";

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
        public List <Offer> selectAllOffer(){
         List<Offer> offers = new ArrayList<>();
         try(
                 Connection con = getConnection();
                 PreparedStatement stmt = con.prepareStatement(SELECT_ALL_OFFERS);
                 ){
             ResultSet rs = PreparedStatement.executeQuery();

         }
        }
        return List<Offer>;
    }



