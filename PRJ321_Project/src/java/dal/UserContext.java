/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import model.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class UserContext extends DBContext {

    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList();
        try {
            String query = "SELECT [ID]\n"
                    + "      ,[Username]\n"
                    + "      ,[Password]\n"
                    + "  FROM [User]";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("ID"));
                u.setUsername(rs.getString("Username"));
                u.setPassword(rs.getString("Password"));
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public User get(String username, String password) {

        try {
            String query = "SELECT [ID]\n"
                    + "      ,[Username]\n"
                    + "      ,[Password]\n"
                    + "  FROM [User] WHERE Username = ? AND Password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("ID"));
                u.setUsername(username);
                u.setPassword(password);
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public User get(String username) {

        try {
            String query = "SELECT [ID]\n"
                    + "      ,[Username]\n"
                    + "      ,[Password]\n"
                    + "  FROM [User] WHERE Username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("ID"));
                u.setUsername(username);
                u.setPassword(rs.getString("Password"));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public User get(int userID) {

        try {
            String query = "SELECT [ID]\n"
                    + "      ,[Username]\n"
                    + "      ,[Password]\n"
                    + "  FROM [User] WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("ID"));
                u.setUsername(rs.getString("Username"));
                u.setPassword(rs.getString("Password"));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void add(String username, String password) {
        try {
            String query = "INSERT INTO [dbo].[User]\n"
                    + "           ([Username]\n"
                    + "           ,[Password])\n"
                    + "     VALUES\n"
                    + "           ('" + username + "'\n"
                    + "           ,'" + password + "')";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
