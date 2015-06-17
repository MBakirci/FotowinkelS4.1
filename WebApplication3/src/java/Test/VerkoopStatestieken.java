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
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 *
 * @author Coen
 */
public class VerkoopStatestieken {
    public static HashMap<String, Object> MaandVerkoop(Calendar maand) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException{
        Calendar firstDay = new GregorianCalendar();
        Calendar lastDay = new GregorianCalendar();
        firstDay.set(maand.get(maand.YEAR), maand.get(maand.MONTH)-1, 1);
        lastDay.set(maand.get(maand.YEAR), maand.get(maand.MONTH)-1, maand.getInstance().getActualMaximum(maand.DAY_OF_MONTH));
        return Verkoop(firstDay, lastDay);
    }
    
    public static HashMap<String, Object> JaarVerkoop(Calendar jaar) throws ClassNotFoundException, InstantiationException, InstantiationException, SQLException, IllegalAccessException{
        Calendar firstDay = new GregorianCalendar();
        Calendar lastDay = new GregorianCalendar();
        firstDay.set(jaar.get(jaar.YEAR), 0, 1);
        lastDay.set(jaar.get(jaar.YEAR), 11, 31);
        return Verkoop(firstDay, lastDay);
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
                        + "and b.BESTELDATUM between ? and ?";
                state = ts.conn.prepareStatement(querry);
                state.setDate(1, ToSQLDate(StartDate));
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
        and b.BESTELDATUM between ? and ?*/
        return null;
    }
    
//    public static HashMap<String, Object> FotograafMaandVerkoop(Calendar maand, User user){
//        return FotograafMaandVerkoop(maand, user.geteMail());
//    }
    
    public static HashMap<String, Object> FotograafMaandVerkoop(Calendar maand, String email){
        Calendar firstDay = new GregorianCalendar();
        Calendar lastDay = new GregorianCalendar();
        firstDay.set(maand.get(maand.YEAR), maand.get(maand.MONTH)-1, 1);
        lastDay.set(maand.get(maand.YEAR), maand.get(maand.MONTH)-1, maand.getInstance().getActualMaximum(maand.DAY_OF_MONTH));
        return FotograafVerkoop(firstDay, lastDay, email);
    }
    
//    public static HashMap<String, Object> FotograafJaarVerkoop(Calendar jaar, User user){
//        return FotograafJaarVerkoop(jaar, user.geteMail());
//    }
    
    public static HashMap<String, Object> FotograafJaarVerkoop(Calendar jaar, String email){
        Calendar firstDay = new GregorianCalendar();
        Calendar lastDay = new GregorianCalendar();
        firstDay.set(jaar.get(jaar.YEAR), 0, 1);
        lastDay.set(jaar.get(jaar.YEAR), 11, 31);
        return FotograafVerkoop(firstDay, lastDay, email);
    }
    
    public static HashMap<String, Object> FotograafVerkoop(Calendar StartDate, Calendar EndDate, String email){
        HashMap<String, Object> stats = new HashMap<>();
        Databaseconnector ts = new Databaseconnector();
        try {
            if(ts.verbindmetDatabase()){
                PreparedStatement state = null;
                String querry = "Select sum(pf.AANTAL) as items, sum(pf.PRIJS*pf.AANTAL) as omzet, sum(pf.PRIJS*pf.AANTAL*(pf.BTW/100)) as btw " +
                        "From FW_Bestelling b, FW_PRODUCT_FOTO pf , FW_FOTO f, FW_ACCOUNT a " +
                        "Where b.BESTELLINGID = pf.FK_BESTELLINGID " +
                        "and f.UNIQUECODE = pf.FOTOCODE " +
                        "and a.ACCOUNT_ID = f.FOTOGRAAFID " +
                        "and b.BESTELDATUM between ? and ? " +
                        "and a.EMAIL = ?";
                state = ts.conn.prepareStatement(querry);
                state.setDate(1, ToSQLDate(StartDate));
                state.setDate(2, ToSQLDate(EndDate));
                state.setString(3, email);
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
        From FW_Bestelling b, FW_PRODUCT_FOTO pf , FW_FOTO f, FW_ACCOUNT a
        Where b.BESTELLINGID = pf.FK_BESTELLINGID
        and f.UNIQUECODE = pf.FOTOCODE
        and a.ACCOUNT_ID = f.FOTOGRAAFID
        and b.BESTELDATUM between ? and ?
        and a.EMAIL = ?;*/
        return null;
    }
    
    public static java.sql.Date ToSQLDate(Calendar input){
        java.util.Date date = input.getTime();
        return new java.sql.Date(date.getTime());
    }
}
