/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import model.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CourseContext extends DBContext<Course> {

    public Course get(int id) {
        try {
            String query = "SELECT [ID]\n"
                    + "      ,[Name]\n"
                    + "      ,[Description]\n"
                    + "  FROM [Course]";
            PreparedStatement s = connection.prepareStatement(query);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {               
                    Course c = new Course();
                    c.setId(rs.getInt("ID"));
                    c.setName(rs.getString("Name"));
                    c.setDescription(rs.getString("Description"));
                    return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
