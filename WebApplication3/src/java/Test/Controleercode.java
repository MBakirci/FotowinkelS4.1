/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author hsm
 */
public class Controleercode {
     private String Code;

    public Controleercode(String code ) {
        this.Code = code;
        
    }

    public boolean Verbind() throws Exception {
        Databaseconnector ts = new Databaseconnector();
        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;
            try {
                String q = "SELECT * FROM FW_FOTO WHERE UNIQUECODE = ?";
                state = ts.conn.prepareStatement(q);
                state.setString(1, Code);
                
                if (q != null){
                //state.executeQuery();
                state.executeUpdate();
                return true;}
                else{ return false;}
              
            } catch (SQLException e) {
                return false;
            } finally {
                if (state != null) {
                    state.close();
                }
                ts.verbindingverbrekenmetDatabase();
            }
        }
        return true;
    }    
}
