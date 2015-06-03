/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dennis
 */
public class AccountInfo {

    public AccountInfo() {

    }

    public ArrayList getDBInfo(String email) throws ClassNotFoundException, InstantiationException, SQLException {
        //get existing info
        String userID = getUserID(email);
        ArrayList UserInfo = new ArrayList();

        Test.Databaseconnector ts = new Test.Databaseconnector();
        try {
            if (ts.verbindmetDatabase()) {
                PreparedStatement state = null;
                PreparedStatement state2 = null;
                try {
                    //Update gebruiker gedeelte van fotograaf
                    String SelectBase = 
                            "select a.voornaam, a. tussenvoegsel, a.achternaam, a.email," +
                    " from FW_ACCOUNT a Where A.ACCOUNT_ID = ?";
                    state = ts.conn.prepareStatement(SelectBase);
                    state.setString(1, userID);
                    ResultSet rs = state.executeQuery();

                    if (rs.next()) {
                        UserInfo.add(rs.getString("VOORNAAM"));
                        UserInfo.add(rs.getString("TUSSENVOEGSEL"));
                        UserInfo.add(rs.getString("ACHTERNAAM"));
                        UserInfo.add(rs.getString("EMAIL"));
                    }
                    
                    String SelectAdditionalInfo = "select b.TELEFOON, b.STRAAT, b.HUISNUMMER, b.POSTCODE, b.STAD" + 
                            " from FW_ACCOUNT_Gegevens b where B.ACCOUNT_ID = ?";
                    state2 = ts.conn.prepareStatement(SelectAdditionalInfo);
                    state2.setString(1, userID);
                    ResultSet rs2 = state.executeQuery();
                    
                    if (rs2.next()) {
                        UserInfo.add(rs.getString("TELEFOON"));
                        UserInfo.add(rs.getString("STRAAT"));
                        UserInfo.add(rs.getString("HUISNUMMER"));
                        UserInfo.add(rs.getString("POSTCODE"));
                        UserInfo.add(rs.getString("STAD"));
                    }
                    return UserInfo;
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
        return null;
    }

    public void changeAccountInfo(String sessionName, String email, String telnr, String pass, String passver, String fname, String lname, String street, String housenumber, String zipcode, String city) throws ClassNotFoundException, InstantiationException, SQLException {
        if (verifyPassword(pass, passver)) {
            Test.Databaseconnector ts = new Test.Databaseconnector();
            try {
                if (ts.verbindmetDatabase()) {
                    PreparedStatement state = null;
                    PreparedStatement state2 = null;
                    try {
                        //Update gebruiker gedeelte van fotograaf
                        String q = "Update GEBRUIKER SET EMAIL=?, WACHTWOORD=?, VOORNAAM=?, ACHTERNAAM=? where EMAIL = ?";
                        state = ts.conn.prepareStatement(q);
                        state.setString(1, email);
                        state.setString(2, pass);
                        state.setString(3, fname);
                        state.setString(4, lname);
                        state.setString(5, sessionName);
                        state.executeUpdate();
                        
                        String userid = getUserID(email);
                        int userId = Integer.parseInt(userid);
                        int houseNumber = Integer.parseInt(housenumber);
                        //Update fotograaf gedeelte
                        String p = "Update FOTOGRAAF set POSTCODE=?, STRAAT=?, STAD=?, HUISNUMMER=?, TELEFOON=? where ID=?";
                        state2 = ts.conn.prepareStatement(p);
                        state2.setString(1, zipcode);
                        state2.setString(2, street);
                        state2.setString(3, city);
                        state2.setInt(4, houseNumber);
                        state2.setString(5, telnr);
                        state2.setInt(6, userId);
                        state2.executeUpdate();
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
        }

    }

    public String getUserID(String email) throws SQLException, ClassNotFoundException, InstantiationException {
        String resultString = "";

        Test.Databaseconnector ts = new Test.Databaseconnector();
        try {
            if (ts.verbindmetDatabase()) {
                PreparedStatement state = null;
                try {
                    //Update gebruiker gedeelte van fotograaf
                    String q = "SELECT ID from GEBRUIKER where EMAIL=?";
                    state = ts.conn.prepareStatement(q);
                    state.setString(1, email);
                    ResultSet gebruikersID = state.executeQuery();

                    if (gebruikersID.next()) {
                        resultString = gebruikersID.getString("ID");
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
        return resultString;
    }

    public boolean verifyPassword(String password, String passwordVerify) {
        if (password.equals(passwordVerify)) {
            return true;
        } else {
            return false;
        }
    }
}
