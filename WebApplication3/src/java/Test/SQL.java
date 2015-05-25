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
public class SQL {
    
    public Boolean koppeling(int id, String source) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException
    {
        Databaseconnector ts = new Databaseconnector();
        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;
            
            try {
                //String q = "INSERT INTO FW_FOTO (BASISPRIJS) VALUES(?)";
                
                String q = "INSERT INTO FW_KLANT_FOTO (FOTOCODE, KLANTID) VALUES(?,?)";
                state = ts.conn.prepareStatement(q);
                state.setString(1, source);
                state.setInt(2, id);
                
                state.execute();
                //state.executeUpdate();
              
            } catch (SQLException e) {
                return false;
            } finally {
                if (state != null) {
                    state.close();
                }
            }
        }
        return true;
    }
}
