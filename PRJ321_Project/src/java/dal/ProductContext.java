/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author Admin
 */
public class ProductContext extends DBContext<Product> {
    public Product get(int ID) {
        try {
            String query = "SELECT [ProductID]\n" +
                            "      ,[ProductName]\n" +
                            "      ,[ProductPrice]\n" +
                            "      ,[ProductImage]\n" +
                            "  FROM [Product] WHERE ProductID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ID);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                Product p = new Product();
                p.setID(rs.getInt("ProductID"));
                p.setName(rs.getString("ProductName"));
                p.setPrice(rs.getFloat("ProductPrice"));
                p.setImageUrl(rs.getString("ProductImage"));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public ArrayList<Product> getList() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String query = "SELECT [ProductID]\n" +
                            "      ,[ProductName]\n" +
                            "      ,[ProductPrice]\n" +
                            "      ,[ProductImage]\n" +
                            "  FROM [Product]";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Product p = new Product();
                p.setID(rs.getInt("ProductID"));
                p.setName(rs.getString("ProductName"));
                p.setPrice(rs.getFloat("ProductPrice"));
                p.setImageUrl(rs.getString("ProductImage"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
}
