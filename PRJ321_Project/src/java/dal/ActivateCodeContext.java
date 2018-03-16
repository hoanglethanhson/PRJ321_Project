/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ActivateCode;

/**
 *
 * @author Admin
 */
public class ActivateCodeContext extends DBContext<ActivateCode> {

    public ActivateCode getActive(String code, int userID) {
        try {
            //find the code
            String query = "SELECT [ID]\n"
                    + "      ,[UserID]\n"
                    + "      ,[CourseID]\n"
                    + "      ,[isActivated]\n"
                    + "      ,[Code]\n"
                    + "  FROM [ActivateCode] WHERE Code = ? AND isActivated = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, code);
            statement.setBoolean(2, false);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                ActivateCode ac = new ActivateCode();
                ac.setCourseID(rs.getInt("CourseID"));
                ac.setCode(rs.getString("Code"));
                ac.setUserID(userID);
                ac.setActivated(true);
                
                //active the code to the user
                String query1 = "UPDATE [dbo].[ActivateCode]\n"
                        + "   SET [UserID] = ?\n"                       
                        + "      ,[isActivated] = ?\n"                       
                        + " WHERE Code = ?";
                PreparedStatement statement1 = connection.prepareStatement(query1);
                statement1.setInt(1, userID);
                statement1.setBoolean(2, true);
                statement1.setString(3, code);
                statement1.execute();
                
                return ac;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActivateCodeContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
