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
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dennis
 */
public class PhotoCustomer {

    private String getCustomerID(String username) throws SQLException, ClassNotFoundException, InstantiationException {
        String accountID = "";

        Test.Databaseconnector ts = new Test.Databaseconnector();
        try {
            if (ts.verbindmetDatabase()) {
                PreparedStatement state = null;
                try {
                    //Update gebruiker gedeelte van fotograaf
                    String q = "SELECT ACCOUNT_ID from FW_ACCOUNT where EMAIL=?";
                    state = ts.conn.prepareStatement(q);
                    state.setString(1, username);
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

    public ArrayList<String> getAllPhotosCustomer(String usernameString) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        ArrayList photoList = new ArrayList();
        Test.Databaseconnector ts = new Test.Databaseconnector();
        String klantID = getCustomerID(usernameString); // moet nog method voor komen

        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;

            try {
                //Update gebruiker gedeelte van fotograaf
                String q = "SELECT FOTOCODE FROM FW_FOTO_KLANT where KLANTID = ?";
                state = ts.conn.prepareStatement(q);
                state.setString(1, klantID);
                ResultSet rs = state.executeQuery();

                while (rs.next()) {
                    String filepathString = rs.getString("FOTOCODE");
                    String thumbPath = filepathString.substring(filepathString.lastIndexOf("/"));
                    photoList.add("ftp://212.64.126.219:9942/Thumb" + thumbPath);
                }
                return photoList;
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

    public HashSet<String> getCategoryIDs(String usernameString) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        HashSet<String> catList = new HashSet<>();
        Test.Databaseconnector ts = new Test.Databaseconnector();
        String klantID = getCustomerID(usernameString); // moet nog method voor komen

        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;

            try {
                //Update gebruiker gedeelte van fotograaf
                String q = "SELECT CATID FROM FW_FOTO where UNIQUECODE IN (SELECT FOTOCODE FROM FW_KLANT_FOTO where KLANTID = ?)";
                state = ts.conn.prepareStatement(q);
                state.setString(1, klantID);
                ResultSet rs = state.executeQuery();

                while (rs.next()) {
                    catList.add(rs.getString("CATID"));
                }
                return catList;
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

    public HashSet<String> getCategoriesCustomer(String usernameString) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        HashSet<String> categoryList = new HashSet<>();
        Test.Databaseconnector ts = new Test.Databaseconnector();
        String customerID = getCustomerID(usernameString);

        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;
            try {
                //Update gebruiker gedeelte van fotograaf
                String q = "SElECT NAAM FROM FW_CATEGORIE WHERE CATEGORIE_ID IN (SELECT CATID FROM FW_FOTO WHERE UNIQUECODE IN (SELECT FOTOCODE FROM FW_KLANT_FOTO WHERE KlANTID = ?))";
                state = ts.conn.prepareStatement(q);
                state.setString(1, customerID);
                ResultSet rs = state.executeQuery();

                while (rs.next()) {
                    String naam = rs.getString("NAAM");
                    categoryList.add(naam);
                }
                return categoryList;
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

    public String getCatID(String category) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        String catID = "";
        Test.Databaseconnector ts = new Test.Databaseconnector();

        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;
            try {
                //Update gebruiker gedeelte van fotograaf
                String q = "SElECT CATEGORIE_ID FROM FW_CATEGORIE WHERE NAAM = ?";
                state = ts.conn.prepareStatement(q);
                state.setString(1, category);
                ResultSet rs = state.executeQuery();

                while (rs.next()) {
                    catID = rs.getString("CATEGORIE_ID");
                }
                return catID;
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

    public ArrayList<String> getCatPhotosCustomer(String usernameString, String category) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        ArrayList photoList = new ArrayList();
        Test.Databaseconnector ts = new Test.Databaseconnector();
        String klantID = getCustomerID(usernameString); // moet nog method voor komen
        String catID = getCatID(category);

        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;

            try {
                //Update gebruiker gedeelte van fotograaf
                String q = "SElECT FILEPATH FROM FW_FOTO WHERE CATID = ? AND UNIQUECODE IN (SELECT FOTOCODE FROM FW_KLANT_FOTO WHERE KLANTID = ?)";
                state = ts.conn.prepareStatement(q);
                state.setString(1, catID);
                state.setString(2, klantID);
                ResultSet rs = state.executeQuery();

                while (rs.next()) {
                    String filepathString = rs.getString("FILEPATH");
                    String thumbPath = filepathString.substring(filepathString.lastIndexOf("/"));
                    photoList.add("ftp://212.64.126.219:9942/Thumb" + thumbPath);
                }
                return photoList;
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
