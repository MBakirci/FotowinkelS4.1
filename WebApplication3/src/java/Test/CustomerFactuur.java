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
public class CustomerFactuur {
    
    public CustomerFactuur()
    {
        
    }
    public ArrayList<Test.WinkelWagenItem> OrdersList(String orderid) throws ClassNotFoundException, SQLException, InstantiationException
    {
        try {
            ArrayList <Test.WinkelWagenItem> orderlist = new ArrayList<Test.WinkelWagenItem>();
            Test.Databaseconnector ts = new Test.Databaseconnector();
            
            if (ts.verbindmetDatabase()) {
                PreparedStatement state = null;
                try {
                    //Update gebruiker gedeelte van fotograaf
                    String q = "Select b.nameforfactuur, b.aantal, b.ptype, c.naam, b.prijs, b.fotocode, b.x, b.y, b.length, b.width, b.valuta from fw_bestelling a, fw_product_foto b, fw_product c where a.bestellingid = b.fk_bestellingid and b.productid = c.productid and bestellingid = ?";
                    state = ts.conn.prepareStatement(q);
                    state.setString(1, orderid);
                    ResultSet rs = state.executeQuery();
                    
                    while (rs.next()) {
                        Test.WinkelWagenItem item  = new Test.WinkelWagenItem(rs.getString("nameforfactuur"), rs.getInt("aantal"), rs.getString("ptype"), rs.getString("naam"), rs.getDouble("prijs"), rs.getString("fotocode"), rs.getInt("x"), rs.getInt("y"), rs.getInt("length"), rs.getInt("width"), rs.getString("valuta"));
                        orderlist.add(item);
                    }
                    return orderlist;
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
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CustomerFactuur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

}
