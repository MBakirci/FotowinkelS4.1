package Test;

import java.sql.*;
import java.util.*;
import java.util.Date;
import javax.servlet.http.HttpSession;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gebruiker
 */
public class Verwijderaccount {

    //email
    private String Naam;

    public String getNaam() {
        return Naam;
    }

    //constructor
    public Verwijderaccount(String naam) {
        this.Naam = naam;

    }

    public Verwijderaccount() {

    }

    public HashMap<String,String> getallUsers() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String sql = "select * from FW_ACCOUNT";
        Test.Databaseconnector connection = new Test.Databaseconnector();
        PreparedStatement state = null;
        try {
            if (connection.verbindmetDatabase()) {
                state = connection.conn.prepareStatement(sql);
                ResultSet rs = state.executeQuery();
                HashMap<String,String> enableList = new HashMap<>();
                while (rs.next()) {
                    String getActief = "Actief";
                    if (!rs.getString("ENABLED").equals("1")) {
                        getActief = "Non-Actief";
                        String non = "background: #009966; color: #FFF;";
                    }
                    this.Naam = rs.getString("EMAIL");
                    String result = getNaam() + " | " + getActief;
                    enableList.put(getNaam(), result);
                }
                return enableList;    
            }
            }catch (SQLException e) {
            System.out.println(e.toString());
        }finally {
            if (state != null) {
                state.close();
            }
            connection.verbindingverbrekenmetDatabase();
        }
            return null;
        }
        //methode die de status op nonactief zet
    public boolean Zetstatusnonactief() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //db connectie maken
        Databaseconnector ts = new Databaseconnector();
        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;
            PreparedStatement state1 = null;

            try {
                String a = "Select EMAIL FROM FW_ACCOUNT WHERE EMAIL = ?";
                state1 = ts.conn.prepareStatement(a);
                state1.setString(1, Naam);
                ResultSet rs = state1.executeQuery();

                while (rs.next()) {
                    //prepared sql statement die status op non actief zet
                    String q = "UPDATE FW_ACCOUNT SET ENABLED = 0 WHERE EMAIL =?";
                    //String q = "INSERT INTO GEBRUIKER (EMAIL,WACHTWOORD, VOORNAAM, TUSSENVOEGSEL, ACHTERNAAM) VALUE( ?, ?, ? , ? ,?)";
                    state = ts.conn.prepareStatement(q);
                    state.setString(1, Naam);

                    //state.executeQuery();
                    state.executeUpdate();
                    return true;

                }

            } catch (SQLException e) {
                //mislukt en toont error msg op screen
                System.out.print("email bestaat al");
                return false;
            } finally {
                //closed altijd de state
                if (state != null) {
                    state.close();
                }
                if (state1 != null) {
                    state1.close();
                }
                ts.verbindingverbrekenmetDatabase();
            }
        }

        return false;
    }

    public boolean Zetstatusactief() throws Exception {
        //database connectie wordt opgezet
        Databaseconnector ts = new Databaseconnector();
        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;
            PreparedStatement state1 = null;
            try {
                String a = "Select EMAIL FROM FW_ACCOUNT WHERE EMAIL = ?";
                state1 = ts.conn.prepareStatement(a);
                state1.setString(1, Naam);
                ResultSet rs = state1.executeQuery();

                while (rs.next()) {
                    //status weer naar actief zetten
                    String q = "UPDATE FW_ACCOUNT SET ENABLED = 1 WHERE EMAIL =?";
                    //String q = "INSERT INTO GEBRUIKER (EMAIL,WACHTWOORD, VOORNAAM, TUSSENVOEGSEL, ACHTERNAAM) VALUE( ?, ?, ? , ? ,?)";
                    state = ts.conn.prepareStatement(q);
                    state.setString(1, Naam);

                    //state.executeQuery();
                    state.executeUpdate();
                    return true;
                    // return true als het gelukt is
                }

            } catch (SQLException e) {
                // als het mislukt is toon dan de error message op het scherm
                System.out.print(e.toString());
                return false;
            } finally {
                //close de state
                if (state1 != null) {
                    state1.close();
                }
                if (state != null) {
                    state.close();
                }

                ts.verbindingverbrekenmetDatabase();
            }
        }
        return false;
    }
}
