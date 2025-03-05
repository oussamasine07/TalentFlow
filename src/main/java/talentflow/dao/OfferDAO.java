package talentflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

    public class OfferDAO extends ConnectToDB {
        private static final String INSERT_INTO_OFFERS = "INSERT INTO offers (title, description, date) VALUES (?, ?, ?);";
        private static final String SELECT_ALL_OFFERS = "SELECT * FROM offers";
        private static final String DELET_OFFERS_BY_ID = "DELETE FROM offers where";

        public OfferDAO (){}

        public void addOffer(){
            try (
                    Connection con = getConnection();
                    PreparedStatement stmt = con.prepareStatement(INSERT_INTO_OFFERS, Statement.RETURN_GENERATED_KEYS);
            ){
                stmt.setString(1,"title");
                stmt.setString(2,"description");
                stmt.setString(3,"datetime");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


