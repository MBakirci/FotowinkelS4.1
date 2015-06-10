/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.sun.xml.ws.tx.at.v10.types.PrepareResponse;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author Coen
 */
public class VerkoopStatestieken {
    public static HashMap<String, Object> MaandVerkoop(Calendar maand) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException{
        Calendar firstDay = maand;
        Calendar lastDay = maand;
        firstDay.set(Calendar.DAY_OF_MONTH, maand.getActualMinimum(Calendar.DAY_OF_MONTH));
        lastDay.set(Calendar.DAY_OF_MONTH, maand.getActualMaximum(Calendar.DAY_OF_MONTH));
        HashMap<String, Object> result;
        result = Verkoop(firstDay, lastDay);
        return result;
    }
    
    public static HashMap<String, Object> JaarVerkoop(Calendar jaar) throws ClassNotFoundException, InstantiationException, InstantiationException, SQLException, IllegalAccessException{
        Calendar firstDay = jaar;
        Calendar lastDay = jaar;
        firstDay.set(Calendar.DAY_OF_MONTH, 1);
        lastDay.set(Calendar.DAY_OF_MONTH, 31);
        firstDay.set(Calendar.MONTH, 1);
        lastDay.set(Calendar.MONTH, 12);
        HashMap<String, Object> result;
        result = Verkoop(firstDay, lastDay);
        return result;
    }
    
    public static HashMap<String, Object> Verkoop(Calendar StartDate, Calendar EndDate) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, SQLException, SQLException, IllegalAccessException{
        HashMap<String, Object> stats = new HashMap<>();
        Databaseconnector ts = new Databaseconnector();
        try {
            if(ts.verbindmetDatabase()){
                PreparedStatement state = null;
                String querry = "Select sum(pf.AANTAL) as items, sum(pf.PRIJS*pf.AANTAL) as omzet, sum(pf.PRIJS*pf.AANTAL*(pf.BTW/100)) as btw "
                        + "From FW_Bestelling b, FW_PRODUCT_FOTO pf "
                        + "Where b.BESTELLINGID = pf.FK_BESTELLINGID "
                        + "and b.BESTELDATUM between :? and :?";
                state = ts.conn.prepareStatement(querry);
                java.sql.Date d = ToSQLDate(StartDate);
                state.setDate(1, d);
                state.setDate(2, ToSQLDate(EndDate));
                ResultSet result = state.executeQuery();
                if(result.next()){
                    stats.put("items", result.getInt("items"));
                    stats.put("omzet", result.getInt("omzet"));
                    stats.put("btw", result.getInt("btw"));
                }
                return stats;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ts.close();
        }
        
        /*Select sum(pf.AANTAL) as items, sum(pf.PRIJS*pf.AANTAL) as omzet, sum(pf.PRIJS*pf.AANTAL*(pf.BTW/100)) as btw
        From FW_Bestelling b, FW_PRODUCT_FOTO pf
        Where b.BESTELLINGID = pf.FK_BESTELLINGID
        and b.BESTELDATUM between :? and :?*/
        return null;
    }
    
    public static HashMap<String, Object> FotograafMaandVerkoop(User user){
        HashMap<String, Object> result = FotograafMaandVerkoop(user.geteMail());
        return result;
    }
    
    public static HashMap<String, Object> FotograafMaandVerkoop(String email){
        return null;
    }
    
    public static HashMap<String, Object> FotograafJaarVerkoop(User user){
        HashMap<String, Object> result = FotograafJaarVerkoop(user.geteMail());
        return result;
    }
    
    public static HashMap<String, Object> FotograafJaarVerkoop(String email){
        return null;
    }
    
    public static java.sql.Date ToSQLDate(Calendar input){
        java.util.Date date = input.getTime();
        return new java.sql.Date(date.getTime());
    }
}
