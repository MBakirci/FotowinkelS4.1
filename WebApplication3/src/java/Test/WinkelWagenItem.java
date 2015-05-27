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
 * @author asror
 */
public class WinkelWagenItem {
    private String productnaam;
    private Integer aantal;
    private String kleurtype;
    private String producttype;
    private Double prijs;
    private String fotocode;
    private Double xcor;
    private Double ycor;
    private Double wamnt;
    private Double hamnt;

    public WinkelWagenItem(String productnaam, Integer aantal, String kleurtype, String producttype, Double prijs, String fotocode, Double X, Double Y, Double wid, Double hei) {
        this.productnaam = productnaam;
        this.aantal = aantal;
        this.kleurtype = kleurtype;
        this.producttype = producttype;
        this.prijs = prijs;
        this.fotocode = fotocode;
        this.xcor = X;
        this.ycor = Y;
        this.wamnt = wid;
        this.hamnt = hei;
    }

    public Double getXcor() {
        return xcor;
    }

    public void setXcor(Double xcor) {
        this.xcor = xcor;
    }

    public Double getYcor() {
        return ycor;
    }

    public void setYcor(Double ycor) {
        this.ycor = ycor;
    }

    public Double getWamnt() {
        return wamnt;
    }

    public void setWamnt(Double wamnt) {
        this.wamnt = wamnt;
    }

    public Double getHamnt() {
        return hamnt;
    }

    public void setHamnt(Double hamnt) {
        this.hamnt = hamnt;
    }

    public void setProductnaam(String productnaam) {
        this.productnaam = productnaam;
    }

    public void setAantal(Integer aantal) {
        this.aantal = aantal;
    }

    public void setKleurtype(String kleurtype) {
        this.kleurtype = kleurtype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public void setPrijs(Double prijs) {
        this.prijs = prijs;
    }

    public void setFotocode(String fotocode) {
        this.fotocode = fotocode;
    }
    
    public String getProductnaam() {
        return productnaam;
    }

    public Integer getAantal() {
        return aantal;
    }

    public String getKleurtype() {
        return kleurtype;
    }

    public String getProducttype() {
        return producttype;
    }

    public Double getPrijs() {
        return prijs;
    }

    public String getfoto() throws ClassNotFoundException, InstantiationException, SQLException
    {

         String foto = "";
         
        Test.Databaseconnector ts = new Test.Databaseconnector();
        try {
            if (ts.verbindmetDatabase()) {
                PreparedStatement state = null;
                try {
                    //Update gebruiker gedeelte van fotograaf
                    String q = "SELECT FilePath from FW_FOTO where UniqueCode =?";
                    state = ts.conn.prepareStatement(q);
                    state.setString(1, fotocode);
                    ResultSet gebruikersType = state.executeQuery();

                    if (gebruikersType.next()) {
                        foto = gebruikersType.getString("FilePath");
                    }
                } catch (SQLException e) {
                    System.out.println(e.toString());
                } finally {
                    if (state != null) {
                        state.close();
                    }
                }
            }
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return foto;
    }
    public String getFotocode() {
        return fotocode;
    }

        
    
   
}
