package talentflow.dao;

import talentflow.model.Recruiter;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecruiterDAO extends ConnectToDB {

    private static final String GET_RECRUITER_BY_USER_ID = "SELECT * FROM recruiters WHERE user_id = ?;";
    private static final String GET_RECRUITER_BY_ID = "SELECT * FROM recruiters WHERE id = ?;";

    public RecruiterDAO () {}

    public Recruiter getRecruiterByUserId ( int userId ) {
        Recruiter recruiter = null;

        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(GET_RECRUITER_BY_USER_ID);
        ){
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String company = rs.getString("company");
                String phone = rs.getString("phone");
                String address = rs.getString("address");

                recruiter = new Recruiter(id, company, phone, address);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return recruiter;
    }

    public Recruiter getRecruiterById ( int userId ) {
        Recruiter recruiter = null;

        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(GET_RECRUITER_BY_ID);
        ){
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String company = rs.getString("company");
                String phone = rs.getString("phone");
                String address = rs.getString("address");

                recruiter = new Recruiter(id, company, phone, address);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return recruiter;
    }


}
