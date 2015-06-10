/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
                ts.verbindingverbrekenmetDatabase();
            }
        }
        return true;
    }
    
      public int AantalBezoekers() throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException
    {
        int b =0;
        Databaseconnector ts = new Databaseconnector();
        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;
           
            try {
                //String q = "INSERT INTO FW_FOTO (BASISPRIJS) VALUES(?)";
               
                 Statement st = ts.conn.createStatement();
                 ResultSet rs1 = st.executeQuery("select AANTAL from FW_BEZOEKERS");
                        while (rs1.next()) {
                            b = rs1.getInt("AANTAL");
                            //  out.println(a);
                        }
                return b;
             //   String q = "SELECT AANTAL FROM FW_BEZOEKERS";
             //   state = ts.conn.prepareStatement(q);
                
                
            //    state.execute();
                //state.executeUpdate();
                 
            } catch (SQLException e) {
                return 0;
            } finally {
                if (state != null) {
                    state.close();
                }
                ts.verbindingverbrekenmetDatabase();
            }
        }
        return b;
    }
}
