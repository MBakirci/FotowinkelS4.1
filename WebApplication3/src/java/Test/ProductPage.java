/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dennis
 */
public class ProductPage {
    String getBasePrice(String fotoID) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
        Databaseconnector ts = new Databaseconnector();
        String basePrice ="";
        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;

            try {
                //Update gebruiker gedeelte van fotograaf
                String q = "SElECT BASISPRIJS FROM FW_FOTO where UNIQUECODE = ?";
                state = ts.conn.prepareStatement(q);
                state.setString(1, fotoID);
                ResultSet rs = state.executeQuery();

                if (rs.next()) {
                    basePrice = rs.getString("BASISPRIJS");
                }
                return basePrice;
            } catch (SQLException e) {
                System.out.println(e.toString());
            } finally {
                if (state != null) {
                    state.close();
                }
            }
        }
        return null;
    }
    
    String getProductPrice(String productnaam) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException
    {
        Databaseconnector ts = new Databaseconnector();
        String Price ="";
        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;

            try {
                //Update gebruiker gedeelte van fotograaf
                String q = "SElECT PRIJS FROM FW_PRODUCT where ARTIKELNAAM = ?";
                state = ts.conn.prepareStatement(q);
                state.setString(1, productnaam);
                ResultSet rs = state.executeQuery();

                if (rs.next()) {
                    Price = rs.getString("PRIJS");
                }
                return Price;
            } catch (SQLException e) {
                System.out.println(e.toString());
            } finally {
                if (state != null) {
                    state.close();
                }
            }
        }
        return null;
    }
    
    String getTypePrice(String type) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException
    {
        Databaseconnector ts = new Databaseconnector();
        String basePrice ="";
        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;

            try {
                //Update gebruiker gedeelte van fotograaf
                String q = "SElECT PRIJS FROM FW_TYPE where PTYPE = ?";
                state = ts.conn.prepareStatement(q);
                state.setString(1, type);
                ResultSet rs = state.executeQuery();

                if (rs.next()) {
                    basePrice = rs.getString("PRIJS");
                    
                }
                return basePrice;
            } catch (SQLException e) {
                System.out.println(e.toString());
            } finally {
                if (state != null) {
                    state.close();
                }
            }
        }
        return null;
    }
}
