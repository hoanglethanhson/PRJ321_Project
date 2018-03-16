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
import model.Invoice;
import model.InvoiceLine;

/**
 *
 * @author Admin
 */
public class InvoiceContext extends DBContext<Invoice> {
    public Invoice insert(Invoice modal) {
        try {
            connection.setAutoCommit(false);
            String queryInsertInvoice = "INSERT INTO [Invoice]\n" +
                            "           (\n" +
                            "           [InvoiceDate]\n" +
                            "           ,[PaymentMethod]\n" +
                            "           ,[UserID])\n" +
                            "     VALUES\n" +
                            "           (" +
                            "           ?\n" +
                            "           ,?\n" +
                            "           ,?)";
            
            PreparedStatement insertInvoice = connection.prepareStatement(queryInsertInvoice);
            insertInvoice.setDate(1, modal.getDate());
            insertInvoice.setString(2, modal.getPaymentMethod());
            insertInvoice.setInt(3, modal.getCustomer().getId());
            insertInvoice.executeUpdate();
            
            String queryGetInvoiceID=" SELECT @@IDENTITY as InvoiceID ";
            PreparedStatement selectInvoiceID = connection.prepareStatement(queryGetInvoiceID);
            ResultSet rs = selectInvoiceID.executeQuery();
            if(rs.next())
            {
                int InvoiceID = rs.getInt("InvoiceID");
                modal.setInvoiceID(InvoiceID);
            }
            else
            {
                throw new SQLException();
            }
            
            String insertInvoiceLine = "INSERT INTO [InvoiceLine]\n" +
                                        "           ([InvoiceID]\n" +
                                        "           ,[ProductID]\n" +
                                        "           ,[Quantity]\n" +
                                        "           ,[UnitPrice])\n" +
                                        "     VALUES\n" +
                                        "           (?\n" +
                                        "           ,?\n" +
                                        "           ,?\n" +
                                        "           ,?)";
            
            for (InvoiceLine line : modal.getLines()) {
                PreparedStatement insertLineStatement = connection.prepareStatement(insertInvoiceLine);
                insertLineStatement.setInt(1, modal.getInvoiceID());
                insertLineStatement.setInt(2, line.getProduct().getID());
                insertLineStatement.setInt(3, line.getQuantity());
                insertLineStatement.setFloat(4, line.getUnitPrice());
                insertLineStatement.executeUpdate();
            }
            connection.commit();
            return modal;
        } catch (SQLException ex) {
            try {
                Logger.getLogger(InvoiceContext.class.getName()).log(Level.SEVERE, null, ex);
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(InvoiceContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        
        return null;
        
    }
}
