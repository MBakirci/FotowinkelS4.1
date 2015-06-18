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

    //Haalt totole verkoop informatie een gekozen maand
    //Invoer:   Calender met het maand en jaar
    //uitvoer:  hashmap met <key, Valeus> voor:
    //          key: items, Value: totaal aantal verkochte items
    //          key: omzet, Value: omzet
    //          key: btw, Value: BTW over de omzet 
    public static HashMap<String, Object> MaandVerkoop(Calendar maand) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        //eerste en laaste datum van opgegeven maand instellen
        Calendar firstDay = new GregorianCalendar();
        Calendar lastDay = new GregorianCalendar();
        // maandgetal moet daadwerkelijk maandgetal -1 zijn om de juiste maande krijgen (januarie = 0, decmenber is 11), 
        // uren minuten en seconden worden toegevoed om geen stukken van eerste en laaste dag te misen.
        firstDay.set(maand.get(maand.YEAR), maand.get(maand.MONTH) - 1, 1, 0, 0, 0); 
        lastDay.set(maand.get(maand.YEAR), maand.get(maand.MONTH) - 1, maand.getInstance().getActualMaximum(maand.DAY_OF_MONTH), 23, 59, 59); 
        return Verkoop(firstDay, lastDay);
    }
    
    //Haalt totole verkoop informatie een gekozen jaar
    //Invoer:   Calender met het jaar
    //uitvoer:  hashmap met <key, Valeus> voor:
    //          key: items, Value: totaal aantal verkochte items
    //          key: omzet, Value: omzet
    //          key: btw, Value: BTW over de omzet 
    public static HashMap<String, Object> JaarVerkoop(Calendar jaar) throws ClassNotFoundException, InstantiationException, InstantiationException, SQLException, IllegalAccessException {
        //eerste en laaste dag van een jaar instellen
        Calendar firstDay = new GregorianCalendar();
        Calendar lastDay = new GregorianCalendar();
        // uren minuten en seconden worden toegevoed om geen stukken van eerste en laaste dag te misen.
        firstDay.set(jaar.get(jaar.YEAR), 0, 1, 0, 0, 0);
        lastDay.set(jaar.get(jaar.YEAR), 11, 31, 23, 59, 59);
        return Verkoop(firstDay, lastDay);
    }
    
    //methode haalt verkoop informatie van de totale verkoop in een gewenste periode uit de database
    //invoer:   Calander met startdatum van de gewenste periode
    //          Calander met einddatum van de gewenst periode
    //uitvoer:  hashmap met <key, Valeus> voor:
    //          key: items, Value: totaal aantal verkochte items in de gevraagde periode
    //          key: omzet, Value: omzet in de gevraade periode
    //          key: btw, Value: BTW over de omzet in de gevraagde periode
    private static HashMap<String, Object> Verkoop(Calendar StartDate, Calendar EndDate) throws ClassNotFoundException, ClassNotFoundException, InstantiationException, SQLException, SQLException, IllegalAccessException {
        //return varibale
        HashMap<String, Object> stats = new HashMap<>();
        Databaseconnector ts = new Databaseconnector();
        //querry uitvoeren
        try {
            if (ts.verbindmetDatabase()) {
                PreparedStatement state = null;
                String querry = "Select sum(pf.AANTAL) as items, sum(pf.PRIJS*pf.AANTAL) as omzet, sum(pf.PRIJS*pf.AANTAL*(pf.BTW/100)) as btw "
                        + "From FW_Bestelling b, FW_PRODUCT_FOTO pf "
                        + "Where b.BESTELLINGID = pf.FK_BESTELLINGID "
                        + "and b.BESTELDATUM between ? and ?";
                state = ts.conn.prepareStatement(querry);
                state.setDate(1, ToSQLDate(StartDate));
                state.setDate(2, ToSQLDate(EndDate));
                ResultSet result = state.executeQuery();
                if (result.next()) {
                    stats.put("items", result.getInt("items"));
                    stats.put("omzet", result.getInt("omzet"));
                    stats.put("btw", result.getInt("btw"));
                }
                //als de querry succesvol is uitgevoerd worden de gevonden resulteren gereturned
                return stats;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ts.close();
        }
        //als er een fout optreed bij het uitvoeren van de querry,
        //wordt de hashmap ingesteld met de keys die worden gebruikt met als values xxx. 
        //Dit is om een nullpointer excetion te verkomen bij het visualerzen van de data.
        stats.put("items", "xxx");
        stats.put("omzet", "xxx");
        stats.put("btw", "xxx");
        return stats;
    }
    
    //Haalt verkoop informatie van fotograaf op van een gekozen maand
    //Invoer:   Calender met het maand en jaar
    //          String met email adres
    //uitvoer:  hashmap met <key, Valeus> voor:
    //          key: items, Value: totaal aantal verkochte items
    //          key: omzet, Value: omzet
    //          key: btw, Value: BTW over de omzet 
    public static HashMap<String, Object> FotograafMaandVerkoop(Calendar maand, String email) {
        //eerste en laaste datum van opgegeven maand instellen
        Calendar firstDay = new GregorianCalendar();
        Calendar lastDay = new GregorianCalendar();
        // maandgetal moet daadwerkelijk maandgetal -1 zijn om de juiste maande krijgen (januarie = 0, decmenber is 11), 
        // uren minuten en seconden worden toegevoed om geen stukken van eerste en laaste dag te misen.
        firstDay.set(maand.get(maand.YEAR), maand.get(maand.MONTH) - 1, 1, 0, 0, 0);
        lastDay.set(maand.get(maand.YEAR), maand.get(maand.MONTH) - 1, maand.getInstance().getActualMaximum(maand.DAY_OF_MONTH), 23, 59, 59);
        return FotograafVerkoop(firstDay, lastDay, email);
    }
    
    //Haalt verkoop informatie van fotograaf op van een gekozen jaar
    //Invoer:   Calender met het jaar
    //          String met email adres
    //uitvoer:  hashmap met <key, Valeus> voor:
    //          key: items, Value: totaal aantal verkochte items
    //          key: omzet, Value: omzet
    //          key: btw, Value: BTW over de omzet 
    public static HashMap<String, Object> FotograafJaarVerkoop(Calendar jaar, String email) {
        //eerste en laaste dag van een jaar instellen
        Calendar firstDay = new GregorianCalendar();
        Calendar lastDay = new GregorianCalendar();
        // uren minuten en seconden worden toegevoed om geen stukken van eerste en laaste dag te misen.
        firstDay.set(jaar.get(jaar.YEAR), 0, 1, 0, 0, 0);
        lastDay.set(jaar.get(jaar.YEAR), 11, 31, 23, 59, 59);
        return FotograafVerkoop(firstDay, lastDay, email);
    }

    //methode haalt verkoop informatie van een fotograaf in gewenste periode op uit de datebase
    //invoer:   Calander met startdatum van de gewenste periode
    //          Calander met einddatum van de gewenst periode
    //          String met geweste mail adres
    //uitvoer:  hashmap met <key, Valeus> voor:
    //          key: items, Value: totaal aantal verkochte items in de gevraagde periode
    //          key: omzet, Value: omzet in de gevraade periode
    //          key: btw, Value: BTW over de omzet in de gevraagde periode
    private static HashMap<String, Object> FotograafVerkoop(Calendar StartDate, Calendar EndDate, String email) {
        //return varibale
        HashMap<String, Object> stats = new HashMap<>();
        //check of email bestaat
        if (checkEmail(email)) {
            //querry uitvoeren
            Databaseconnector ts = new Databaseconnector();
            try {
                if (ts.verbindmetDatabase()) {
                    PreparedStatement state = null;
                    String querry = "Select sum(pf.AANTAL) as items, sum(pf.PRIJS*pf.AANTAL) as omzet, sum(pf.PRIJS*pf.AANTAL*(pf.BTW/100)) as btw "
                            + "From FW_Bestelling b, FW_PRODUCT_FOTO pf , FW_FOTO f, FW_ACCOUNT a "
                            + "Where b.BESTELLINGID = pf.FK_BESTELLINGID "
                            + "and f.UNIQUECODE = pf.FOTOCODE "
                            + "and a.ACCOUNT_ID = f.FOTOGRAAFID "
                            + "and b.BESTELDATUM between ? and ? "
                            + "and a.EMAIL = ?";
                    state = ts.conn.prepareStatement(querry);
                    state.setDate(1, ToSQLDate(StartDate));
                    state.setDate(2, ToSQLDate(EndDate));
                    state.setString(3, email);
                    ResultSet result = state.executeQuery();
                    if (result.next()) {
                        stats.put("items", result.getInt("items"));
                        stats.put("omzet", result.getInt("omzet"));
                        stats.put("btw", result.getInt("btw"));
                    }
                    //als de querry succesvol is uitgevoerd worden de gevonden resulteren gereturned
                    return stats;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ts.close();
            }
        }
        //als er een fout optreed bij het uitvoeren van de querry of het email adres niet bestaat,
        //wordt de hashmap ingesteld met de keys die worden gebruikt met als values xxx. 
        //Dit is om een nullpointer excetion te verkomen bij het visualerzen van de data.
        stats.put("items", "xxx");
        stats.put("omzet", "xxx");
        stats.put("btw", "xxx");
        return stats;
    }
    
    //methode zet Calander object om in een dat data object dat te gebruiken is 
    //in een prepared statement
    //invoer: Calander
    //uitvoer: java.sql.Date
    private static java.sql.Date ToSQLDate(Calendar input) {
        java.util.Date date = input.getTime();
        return new java.sql.Date(date.getTime());
    }

    //Methode die check of email bestaat in de database
    //invoer: String die email adres bevat
    //uitvoer: booleaan
    //      true: email adres bestaat
    //      false: email adres bestaat niet
    private static boolean checkEmail(String email) {
        //aantal keer dat het eamil adres voorkomt, als er een fout optreed in het 
        //uitvoeren van de methode word er false gereturned
        int aantal = 0;
        Databaseconnector ts = new Databaseconnector();
        try {
            if (ts.verbindmetDatabase()) {
                PreparedStatement state = null;
                //querry telt het voorkomen van het email adres in de database
                String querry = "Select count(*) as aantal "
                        + "from FW_ACCOUNT a "
                        + "where a.EMAIL = ? "
                        + "and a.ATYPE = 'fotograaf'";
                state = ts.conn.prepareStatement(querry);
                state.setString(1, email);
                ResultSet result = state.executeQuery();
                if (result.next()) {
                    aantal = result.getInt("aantal");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ts.close();
        }
        //als het email adres voorkomt return true
        return aantal > 0;
    }
}
