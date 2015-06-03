/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dennis
 */
public class ProductPage {
    public String getBasePrice(String fotoID) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException 
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
                ts.verbindingverbrekenmetDatabase();
            }
        }
        return null;
    }
    
    public ArrayList<Double> getColorPrice() throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException
    {
        Databaseconnector ts = new Databaseconnector();
        ArrayList<Double> Price = new ArrayList<Double>();
        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;

            try {
                //Update gebruiker gedeelte van fotograaf
                String q = "SElECT PRIJS FROM FW_TYPE";
                state = ts.conn.prepareStatement(q);
                ResultSet rs = state.executeQuery();

                while (rs.next()) {
                    Price.add(rs.getDouble("PRIJS"));
                }
                return Price;
            } catch (SQLException e) {
                System.out.println(e.toString());
            } finally {
                if (state != null) {
                    state.close();
                }
                ts.verbindingverbrekenmetDatabase();
            }
        }
        return null;
    }
    
    public ArrayList<String> getColorName() throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException
    {
        Databaseconnector ts = new Databaseconnector();
        ArrayList<String> Price = new ArrayList<String>();
        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;

            try {
                //Update gebruiker gedeelte van fotograaf
                String q = "SElECT PTYPE FROM FW_TYPE";
                state = ts.conn.prepareStatement(q);
                ResultSet rs = state.executeQuery();

                while (rs.next()) {
                    Price.add(rs.getString("PTYPE"));
                }
                return Price;
            } catch (SQLException e) {
                System.out.println(e.toString());
            } finally {
                if (state != null) {
                    state.close();
                }
                ts.verbindingverbrekenmetDatabase();
            }
        }
        return null;
    }
    
   public ArrayList<Double> getTypePrice() throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException
    {
        Databaseconnector ts = new Databaseconnector();
        ArrayList<Double> Price = new ArrayList<>();
        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;

            try {
                //Update gebruiker gedeelte van fotograaf
                String q = "SElECT PRIJS FROM FW_PRODUCT";
                state = ts.conn.prepareStatement(q);
                ResultSet rs = state.executeQuery();

                while (rs.next()) {
                    Price.add(rs.getDouble("PRIJS"));
                    
                }
                return Price;
            } catch (SQLException e) {
                System.out.println(e.toString());
            } finally {
                if (state != null) {
                    state.close();
                }
                ts.verbindingverbrekenmetDatabase();
            }
        }
        return null;
    }
   
   public ArrayList<String> getTypeName() throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException
    {
        Databaseconnector ts = new Databaseconnector();
        ArrayList<String> Price = new ArrayList<>();
        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;

            try {
                //Update gebruiker gedeelte van fotograaf
                String q = "SElECT NAAM FROM FW_PRODUCT";
                state = ts.conn.prepareStatement(q);
                ResultSet rs = state.executeQuery();

                while (rs.next()) {
                    Price.add(rs.getString("NAAM"));
                    
                }
                return Price;
            } catch (SQLException e) {
                System.out.println(e.toString());
            } finally {
                if (state != null) {
                    state.close();
                }
                ts.verbindingverbrekenmetDatabase();
            }
        }
        return null;
    }
}
