package Test;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Jesper
 */
public final class Databaseconnecter  
{
    /**
     * connectie variabelen
     */
    private Connection conn;
    /**
     * constructor
     */
    public Databaseconnecter() 
    {
//        try {
//            this.verbindmetDatabase();
//        } catch (ClassNotFoundException | InstantiationException | SQLException | IllegalAccessException ex) {
//            Logger.getLogger(Databaseconnector.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
       /**
        * hier maken wij een verbinding in de database
     * @return 
        * @throws ClassNotFoundException exeptions
        * @throws InstantiationException exeptions
        * @throws SQLException exeptions
        * @throws IllegalAccessException exeptions
        */
    public boolean verbindmetDatabase() throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException
    {
        String url = "jdbc:oracle:thin:@fhictora01.fhict.local:1521:fhictora";
        String driver = "oracle.jdbc.OracleDriver";
        String userName = "dbi296880"; 
        String password = "U4XAsfWbUp";
        
        try{
        Class.forName(driver);
        conn = DriverManager.getConnection(url,userName,password);
        System.out.print("succes");
        return true;
        }
        catch (ClassNotFoundException | SQLException ex) {
            String message = ex.getMessage();
            System.out.print(message);
            return false;
        }
        //return false;
//        if (conn != null) {
//		System.out.println("You made it, take control your database now!");
//	} else {
//		System.out.println("Failed to make connection!");
//	}
    }
    /**
     * methode voor het verbreken van de database
     */
    public void verbindingverbrekenmetDatabase() 
    {
        try 
        {
            conn.close();
            conn = null;
        } 
        catch (SQLException ex) 
        {
            System.err.println(ex.getMessage());
        }
    }

    public void close()
    {
        this.verbindingverbrekenmetDatabase();
    }
}