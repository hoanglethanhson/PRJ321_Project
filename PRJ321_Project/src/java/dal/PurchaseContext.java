/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;
import model.Purchase;

/**
 *
 * @author Admin
 */
public class PurchaseContext extends DBContext<Purchase> {

    public Purchase get(int userID, int courseID) {
        try {
            String query = "SELECT [ID]\n"
                    + "      ,[UserID]\n"
                    + "      ,[CourseID]\n"
                    + "      ,[Date]\n"
                    + "  FROM [Purchase] WHERE UserID = ? AND CourseID = ?";
            PreparedStatement s = connection.prepareStatement(query);
            s.setInt(1, userID);
            s.setInt(2, courseID);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                Purchase p = new Purchase();
                p.setUserID(userID);
                p.setCourseID(courseID);
                p.setDate(rs.getDate("Date").toString());
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void add(int userID, int courseID) {
        try {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            String query = "INSERT INTO [Purchase]\n"
                    + "           ([UserID]\n"
                    + "           ,[CourseID]\n"
                    + "           ,[Date])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement s = connection.prepareStatement(query);
            s.setInt(1, userID);
            s.setInt(2, courseID);
            s.setDate(3, date);
            s.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //get all the courses that an user has purchased before
    public Hashtable<Course, Date> getPurchased(int userID) {
        //ArrayList<Course> courses = new ArrayList();
        Hashtable<Course, Date> list = new Hashtable();
        CourseContext cc = new CourseContext();
        try {
            String query = "SELECT \n"
                    + "      [CourseID]\n"
                    + "     , [Date]\n"
                    + "  FROM [Purchase] WHERE UserID = ?";
            PreparedStatement s = connection.prepareStatement(query);
            s.setInt(1, userID);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Course c = cc.get(rs.getInt("CourseID"));
                //courses.add(c);
                list.put(cc.get(rs.getInt("CourseID")), rs.getDate("Date"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
