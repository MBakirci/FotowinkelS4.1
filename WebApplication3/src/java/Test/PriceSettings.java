/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.sun.tools.ws.api.TJavaGeneratorExtension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

/**
 *
 * @author Gebruiker
 */
public class PriceSettings {

    private int typeID = 0;
    private String typeNaam = "";
    private String typeDetails = "";
    private double prijs = 0.00;

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeNaam() {
        return typeNaam;
    }

    public void setTypeNaam(String typeNaam) {
        this.typeNaam = typeNaam;
    }

    public String getTypeDetails() {
        return typeDetails;
    }

    public void setTypeDetails(String typeDetails) {
        this.typeDetails = typeDetails;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    public PriceSettings() {
    }

    public HashMap<Integer, List<String>> getallProductTypes() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Test.Databaseconnector ts = new Test.Databaseconnector();

        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;
            try {
                //Update gebruiker gedeelte van fotograaf
                String q = "select * from FW_PRODUCT";
                state = ts.conn.prepareStatement(q);
                HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
                ResultSet rs = state.executeQuery();
                while (rs.next()) {
                    List<String> valSet = new ArrayList<String>();
                    this.typeID = rs.getInt("PRODUCTID");
                    this.typeNaam = rs.getString("NAAM");
                    this.typeDetails = rs.getString("DETAILS");
                    this.prijs = rs.getDouble("PRIJS");
                    DecimalFormat df = new DecimalFormat("#.00");
                    String Prijs = df.format(prijs);
                    valSet.add(typeNaam);
                    valSet.add(typeDetails);
                    valSet.add(Prijs);
                    map.put(typeID, valSet);
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

    public void EditProductType(int typeID) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String sql = "UPDATE FW_PRODUCT SET NAAM = ?, Details = ?, Prijs = ? WHERE PRODUCTID = ? ";
        Test.Databaseconnector connection = new Test.Databaseconnector();
        if (connection.verbindmetDatabase()) {
            PreparedStatement state = null;
            try {

                state = connection.conn.prepareStatement(sql);
                state.setString(1, this.typeNaam);
                if (this.typeDetails.length() > 0) {
                    state.setString(2, this.typeDetails);
                } else {
                    state.setString(2, "  ");
                }
                state.setDouble(3, this.prijs);
                state.setInt(4, typeID);
                //state.executeQuery();
                state.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.toString());
            } finally {
                if (state != null) {
                    state.close();
                }
                connection.verbindingverbrekenmetDatabase();
            }
        }
    }

    public void AddProductType() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String sql = "INSERT INTO FW_PRODUCT (NAAM, DETAILS, PRIJS) VALUES (?, ?, ?)";
        Test.Databaseconnector connection = new Test.Databaseconnector();

        if (connection.verbindmetDatabase()) {
            PreparedStatement state = null;
            try {

                state = connection.conn.prepareStatement(sql);
                state.setString(1, this.typeNaam);
                if (this.typeDetails.length() > 0) {
                    state.setString(2, this.typeDetails);
                } else {
                    state.setString(2, "   ");
                }
                state.setDouble(3, this.prijs);
                state.executeQuery();
            } catch (SQLException e) {
                System.out.println(e.toString());
            } finally {
                if (state != null) {
                    state.close();
                }
                connection.verbindingverbrekenmetDatabase();
            }
        }

    }
}
