/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Gebruiker
 */
public class User {

    //fields
    private String iD;
    private String voornaam = "";
    private String tussenvoegsel = "";
    private String Achternaam = "";
    private String eMail = "";
    private String telefoon = "";
    private String straat = "";
    private String huisnr = "";
    private String postcode = "";
    private String stad = "";
    private String type = "";

    //Properties
    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return Achternaam;
    }

    public void setAchternaam(String Achternaam) {
        this.Achternaam = Achternaam;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getHuisnr() {
        return huisnr;
    }

    public void setHuisnr(String huisnr) {
        this.huisnr = huisnr;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public User() {

    }

    public User(String email, String wachtwoord,
            String voornaam, String tussenvoegsel,
            String achternaam, String type) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String q = "INSERT INTO FW_ACCOUNT (EMAIL,WACHTWOORD, ENABLED, VOORNAAM, TUSSENVOEGSEL,"
                + " ACHTERNAAM, ATYPE) VALUES(? ,?, ?, ?, ? , ?,?)";
        Test.Databaseconnector connection = new Test.Databaseconnector();
        PreparedStatement state = null;
        try {
            if (connection.verbindmetDatabase()) {
                if (tussenvoegsel == null) {
                    tussenvoegsel = "";
                }

                state = connection.conn.prepareStatement(q);
                this.eMail = email;
                state.setString(1, email);
                state.setString(2, wachtwoord);
                int Actief = 1;
                state.setInt(3, Actief);
                state.setString(4, voornaam);
                state.setString(5, tussenvoegsel);
                state.setString(6, achternaam);
                state.setString(7, type);
                state.executeQuery();
                //

            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            if (state != null) {
                state.close();
            }
            connection.verbindingverbrekenmetDatabase();
        }
    }

    public boolean Fotograaf(String telefoon, String straat, String huisnr,
            String postcode, String stad)
            throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        User a = new User(this.eMail);
        String sql = "Insert into FW_ACCOUNT_GEGEVENS(ACCOUNT_ID, TELEFOON, STRAAT, HUISNUMMER,"
                + " POSTCODE, STAD) VALUES(?, ?, ?, ?, ?, ?) ";
        Test.Databaseconnector connection = new Test.Databaseconnector();
        PreparedStatement state = null;
        try {
            if (connection.verbindmetDatabase()) {

                state = connection.conn.prepareStatement(sql);
                state.setString(1, a.iD);
                state.setString(2, telefoon);
                state.setString(3, straat);
                state.setString(4, huisnr);
                state.setString(5, postcode);
                state.setString(6, stad);
                state.executeQuery();
                return true;
                //
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            if (state != null) {
                state.close();
            }
            connection.verbindingverbrekenmetDatabase();
        }
        return false;
    }

    public User(String email) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        String sql = "Select * from FW_ACCOUNT where EMAIL = ?";
        Test.Databaseconnector connection = new Test.Databaseconnector();
        PreparedStatement state = null;
        try {
            if (connection.verbindmetDatabase()) {

                state = connection.conn.prepareStatement(sql);
                state.setString(1, email);
                ResultSet rs = state.executeQuery();

                if (rs.next()) {
                    this.iD = rs.getString("ACCOUNT_ID");
                    this.voornaam = rs.getString("VOORNAAM");
                    this.tussenvoegsel = rs.getString("TUSSENVOEGSEL");
                    this.Achternaam = rs.getString("ACHTERNAAM");
                    this.eMail = rs.getString("EMAIL");
                    this.type = rs.getString("ATYPE");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            if (state != null) {
                state.close();
            }
            connection.verbindingverbrekenmetDatabase();
        }
    }

    public boolean UpdateUser() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String updateUser = "Update FW_ACCOUNT set VOORNAAM = ?, TUSSENVOEGSEL = ?, ACHTERNAAM = ? "
                + "where ACCOUNT_ID = ?";
        Test.Databaseconnector connection = new Test.Databaseconnector();
        PreparedStatement state = null;
        try {
            if (connection.verbindmetDatabase()) {

                state = connection.conn.prepareStatement(updateUser);
                state.setString(1, this.voornaam);
                state.setString(2, this.tussenvoegsel);
                state.setString(3, this.Achternaam);
                state.setString(4, this.iD);
                state.executeUpdate();
                if (type.equals("fotograaf")) {
                    UpdateAdditionalInfo();
                }
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            if (state != null) {
                state.close();
            }
            connection.verbindingverbrekenmetDatabase();
        }
        return false;
    }

    public void AdditionalInfo() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String sql = "Select * from FW_ACCOUNT_GEGEVENS where ACCOUNT_ID = ?";
        Test.Databaseconnector connection = new Test.Databaseconnector();
        PreparedStatement state = null;
        try {
            if (connection.verbindmetDatabase()) {

                state = connection.conn.prepareStatement(sql);
                state.setInt(1, Integer.parseInt(iD));
                ResultSet rs = state.executeQuery();

                if (rs.next()) {
                    this.straat = rs.getString("STRAAT");
                    this.huisnr = rs.getString("HUISNUMMER");
                    this.postcode = rs.getString("POSTCODE");
                    this.stad = rs.getString("STAD");
                    this.telefoon = rs.getString("TELEFOON");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            if (state != null) {
                state.close();
            }
            connection.verbindingverbrekenmetDatabase();
        }
    }

    private boolean UpdateAdditionalInfo() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String updateAdditional = "Update FW_ACCOUNT_GEGEVENS set TELEFOON = ?, STRAAT = ?,"
                + " HUISNUMMER = ?, POSTCODE = ?, STAD = ? where ACCOUNT_ID = ?";
        Test.Databaseconnector connection = new Test.Databaseconnector();
        PreparedStatement state = null;
        try {
            if (connection.verbindmetDatabase()) {
                state = connection.conn.prepareStatement(updateAdditional);
                state.setString(1, this.telefoon);
                state.setString(2, this.straat);
                state.setString(3, this.huisnr);
                state.setString(4, this.postcode);
                state.setString(5, this.stad);
                state.setString(6, this.iD);
                state.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            if (state != null) {
                state.close();
            }
            connection.verbindingverbrekenmetDatabase();
        }
        return false;
    }

    public boolean changePass(String newPassword) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        if (newPassword.length() > 3) {
            String updatePassword = "Update FW_ACCOUNT set WACHTWOORD = ? where EMAIL = ?";
            Test.Databaseconnector connection = new Test.Databaseconnector();
            PreparedStatement state = null;
            try {
                if (connection.verbindmetDatabase()) {
                    state = connection.conn.prepareStatement(updatePassword);
                    state.setString(1, newPassword);
                    state.setString(2, this.eMail);
                    state.executeUpdate();
                    return true;
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
                return false;
            } finally {
                if (state != null) {
                    state.close();
                }
                connection.verbindingverbrekenmetDatabase();
            }
        }
        return false;
    }

    public void SetProfitMargin(int margin) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //if (this.type.toLowerCase() == "fotograaf"){
        String sql = "UPDATE FW_ACCOUNT SET WINSTMARGE = ? WHERE EMAIL = ?";
        Test.Databaseconnector connection = new Test.Databaseconnector();
        PreparedStatement state = null;
        try {
            if (connection.verbindmetDatabase()) {
                state = connection.conn.prepareStatement(sql);
                state.setInt(1, margin);
                state.setString(2, this.eMail);
                //state.executeQuery();
                state.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            if (state != null) {
                state.close();
            }
            connection.verbindingverbrekenmetDatabase();
        }
        //}
    }

    public int GetProfitMargin() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String sql = "SELECT WINSTMARGE FROM FW_ACCOUNT WHERE EMAIL = ?";
        Test.Databaseconnector connection = new Test.Databaseconnector();
        PreparedStatement state = null;
        try {
            if (connection.verbindmetDatabase()) {
                state = connection.conn.prepareStatement(sql);
                state.setString(1, this.eMail);
                ResultSet result = state.executeQuery();
                if (result.next()) {
                    return result.getInt("WINSTMARGE");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            if (state != null) {
                state.close();
            }
            connection.verbindingverbrekenmetDatabase();
        }
        return 0;
    }

    public HashMap<String, List<String>> getUsers(String AType) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Test.Databaseconnector ts = new Test.Databaseconnector();

        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;
            try {
                //Update gebruiker gedeelte van fotograaf
                if (AType.equals("all")) {
                    String q = "select * from FW_ACCOUNT";
                    state = ts.conn.prepareStatement(q);
                } else {
                    String q = "select * from FW_ACCOUNT WHERE ATYPE = ?";
                    state = ts.conn.prepareStatement(q);
                    state.setString(1, AType);
                }
                HashMap<String, List<String>> map = new HashMap<>();
                ResultSet rs = state.executeQuery();
                while (rs.next()) {
                    String enable = "";
                    List<String> valSet = new ArrayList<>();
                    this.iD = rs.getString("ACCOUNT_ID");
                    this.eMail = rs.getString("EMAIL");
                    this.voornaam = rs.getString("VOORNAAM");
                    this.tussenvoegsel = rs.getString("TUSSENVOEGSEL");
                    if (tussenvoegsel.equals("null")) {
                        this.tussenvoegsel = "";
                    }
                    this.Achternaam = rs.getString("ACHTERNAAM");
                    int enabled = rs.getInt("ENABLED");
                    if (enabled == 1) {
                        enable = "ACTIEF";
                    } else {
                        enable = "NON-ACTIEF";
                    }
                    valSet.add(eMail);
                    valSet.add(voornaam);
                    valSet.add(tussenvoegsel);
                    valSet.add(Achternaam);
                    valSet.add(enable);
                    map.put(iD, valSet);
                }
                return map;
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
