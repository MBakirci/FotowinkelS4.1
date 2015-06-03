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

    public ResultSet getallProductTypes() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Test.Databaseconnector ts = new Test.Databaseconnector();

        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;
            try {
                //Update gebruiker gedeelte van fotograaf
                String q = "select * from FW_PRODUCT";
                state = ts.conn.prepareStatement(q);
                return state.executeQuery();

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
