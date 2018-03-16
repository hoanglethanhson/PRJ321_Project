/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.util.ArrayList;
import model.Lesson;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class LessonContext extends DBContext<Lesson> {

    public ArrayList<Lesson> getAll(int courseID) {
        ArrayList<Lesson> list = new ArrayList();
        try {           
            String query = "SELECT [ID]\n"
                    + "      ,[CourseID]\n"
                    + "      ,[Name]\n"
                    + "      ,[Link]\n"
                    + "      ,[Description]\n"
                    + "  FROM [Lesson] WHERE courseID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, courseID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Lesson l = new Lesson();
                l.setCourseID(courseID);
                l.setName(rs.getString("Name"));
                l.setDescription(rs.getString("Description"));
                l.setLink(rs.getString("Link"));
                list.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
