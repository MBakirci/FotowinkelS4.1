/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hsm
 */
public class Adminbasisprijs {
     private final Double Prijs;
    

    public Adminbasisprijs(Double prijs) {
      this.Prijs = prijs;
    }

    public boolean Checkprijs(String session) throws Exception {
        Databaseconnector ts = new Databaseconnector();
        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;
            String a = getID(session);
            try {
                //String q = "INSERT INTO FW_FOTO (BASISPRIJS) VALUES(?)";
                String q = "UPDATE FW_FOTO SET BASISPRIJS=? WHERE FOTOGRAAFID =?";
                state = ts.conn.prepareStatement(q);
                state.setDouble(1, Prijs);
                state.setString(2, a);
           
                
                //state.executeQuery();
                state.executeUpdate();
              
            } catch (SQLException e) {
                return false;
            } finally {
                if (state != null) {
                    state.close();
                }
                ts.verbindingverbrekenmetDatabase();
            }
        }
        return true;
    }    
    public String getID(String email) throws ClassNotFoundException, InstantiationException, SQLException
    {
        
         String accountID = "";
         
        Test.Databaseconnector ts = new Test.Databaseconnector();
        try {
            if (ts.verbindmetDatabase()) {
                PreparedStatement state = null;
                try {
                    //Update gebruiker gedeelte van fotograaf
                    String q = "SELECT ACCOUNT_ID from FW_ACCOUNT where EMAIL=?";
                    state = ts.conn.prepareStatement(q);
                    state.setString(1, email);
                    ResultSet gebruikersType = state.executeQuery();

                    if (gebruikersType.next()) {
                        accountID = gebruikersType.getString("ACCOUNT_ID");
                    }
                } catch (SQLException e) {
                    System.out.println(e.toString());
                } finally {
                    if (state != null) {
                        state.close();
                    }
                    ts.verbindingverbrekenmetDatabase();
                }
            }
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accountID;
    }
    
}
