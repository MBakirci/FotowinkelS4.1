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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asror
 */
public class CustomerOrders {

    public ArrayList<Test.Order> getAllOrders(String usernameString) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        ArrayList<Test.Order> order = new ArrayList<Test.Order>();
        Test.Databaseconnector ts = new Test.Databaseconnector();
        String klantid = getID(usernameString);
        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;
            try {
                //Update gebruiker gedeelte van fotograaf
                String q = "select c.bestellingid, to_char(c.BESTELDATUM, 'DD MON YYYY') as BESTELDATUM, sum(prijs * aantal)  as price, b.VALUTA from FW_BESTELLING c, fw_PRODUCT_FOTO b where c.bestellingid = b.FK_BESTELLINGID and klantid=?\n"
                        + "Group By c.BESTELLINGID, c.BESTELDATUM, b.valuta, b.fk_bestellingid ORDER BY c.BESTELDATUM DESC";
                state = ts.conn.prepareStatement(q);
                state.setString(1, klantid);
                ResultSet rs = state.executeQuery();

                while (rs.next()) {
                    String bestellingid = rs.getString("bestellingid");
                    String besteldatum = rs.getString("BESTELDATUM");
                    String price = rs.getString("price");
                    String valuta = rs.getString("valuta");
                    Test.Order orderitem = new Test.Order(price, valuta, bestellingid, besteldatum);
                    order.add(orderitem);
                }
                return order;
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

    public String getOrderPrice(String bestellingid) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        Test.Databaseconnector ts = new Test.Databaseconnector();
        String price = "";
        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;
            try {
                //Update gebruiker gedeelte van fotograaf
                String q = "select sum(prijs) as price \n"
                        + "from fw_product_foto\n"
                        + "where fk_bestellingid = ?";
                state = ts.conn.prepareStatement(q);
                state.setString(1, bestellingid);
                ResultSet rs = state.executeQuery();

                if (rs.next()) {
                    price = rs.getString("price");
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
        return price;
    }

    public String getOrderValuta(String bestellingid) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        Test.Databaseconnector ts = new Test.Databaseconnector();
        String price = "";
        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;
            try {
                //Update gebruiker gedeelte van fotograaf
                String q = "select valuta \n"
                        + "from fw_product_foto\n"
                        + "where fk_bestellingid = ?";
                state = ts.conn.prepareStatement(q);
                state.setString(1, bestellingid);
                ResultSet rs = state.executeQuery();

                if (rs.next()) {
                    price = rs.getString("valuta");
                    if (price == null) {
                        price = " ";
                    }
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

        return price;
    }

    public String getOrderDatum(String bestellingid) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        Test.Databaseconnector ts = new Test.Databaseconnector();
        String bestdatum = "";
        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;
            try {
                //Update gebruiker gedeelte van fotograaf
                String q = "select besteldatum \n"
                        + "from fw_bestelling \n"
                        + "where bestellingid = ?";
                state = ts.conn.prepareStatement(q);
                state.setString(1, bestellingid);
                ResultSet rs = state.executeQuery();

                if (rs.next()) {
                    bestdatum = rs.getString("besteldatum");
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
        return bestdatum;
    }

    public String getID(String email) throws ClassNotFoundException, InstantiationException, SQLException {

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
