/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import model.Feedback;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class FeedbackContext extends DBContext<Feedback> {

    public void add(int userID, String content) {
        try {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            String query = "INSERT INTO [Feedback]\n"
                    + "           ([UserID]\n"
                    + "           ,[Content]\n"
                    + "           ,[Date])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement s = connection.prepareStatement(query);
            s.setInt(1, userID);
            s.setString(2, content);
            s.setDate(3, date);
            s.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
