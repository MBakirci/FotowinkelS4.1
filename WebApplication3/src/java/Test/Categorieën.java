/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.apache.commons.net.ftp.FTPClient;
//import oracle.jdbc.OracleTypes;

/**
 *
 * @author Coen
 */
public class Categorieën {
    //huidige categorie
    String CurrentCatogory;
    Databaseconnector dbhelp;

    public Categorieën(){
        dbhelp = new Databaseconnector();
    }
    
    //load all categories form database
    public List<Categorie> GetAllCategories(String fotograaf) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        List<Categorie> categories = new ArrayList<>();
            if (dbhelp.verbindmetDatabase()) {
                PreparedStatement stament = null;
            
                String Query = "SELECT * FROM FW_CATEGORIE WHERE FOTOGRAAFID = ?";
                try {
                    stament = dbhelp.conn.prepareStatement(Query);
                    int fotograafid = getID(fotograaf);
                    stament.setInt(1, fotograafid);
                    ResultSet result = stament.executeQuery();
                    Categorie cat = null;
                    while(result.next()){
                        cat = new Categorie();
                        cat.SetId(result.getInt("CATEGORIE_ID"));
                        cat.SetNaam(result.getString("NAAM"));
                        categories.add(cat);
                    }
                }
            
                catch (SQLException e ){
                    System.out.print(e.toString());
                    categories = null;
                }
                finally{
                    if (stament != null) { stament.close();}
                    dbhelp.verbindingverbrekenmetDatabase();
                }
            }
            return categories;
        }
    
    //set CurrentCategrorie
    public void SetCurrentCategory(String Category){
        this.CurrentCatogory = Category;
    }
    
    public String GetCurrentCategory(){
        return this.CurrentCatogory;
    }
    
        private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
        
    }
        
    //create new categorie
    public void CreateCategory(String category, String fotograaf, String Path) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException{
        Databaseconnector ts = new Databaseconnector();
        if (ts.verbindmetDatabase()) {
            PreparedStatement state = null;
            try {
                String q = "INSERT INTO FW_CATEGORIE (PARENTCATID, NAAM, FTPPATH, FOTOGRAAFID) VALUES(? ,?, ?, ?)";
                state = ts.conn.prepareStatement(q);
                state.setString(1, null);
                state.setString(2, category);
                state.setString(3, Path);
                int graafid = getID(fotograaf);
                state.setInt(4, graafid );
                state.executeQuery();
                //state.executeUpdate();
              
            } catch (SQLException e) {

            } finally {
                if (state != null) {
                    state.close();
                }
                dbhelp.verbindingverbrekenmetDatabase();
            }
        }
    }
    
    
    public int getID(String email) throws ClassNotFoundException, InstantiationException, SQLException
    {

         int accountID = 0;
         
        Test.Databaseconnector ts = new Test.Databaseconnector();
        try {
            if (ts.verbindmetDatabase()) {
                PreparedStatement state = null;
                try {
                    //Update gebruiker gedeelte van fotograaf
                    String q = "SELECT ACCOUNT_ID from FW_ACCOUNT where EMAIL=?";
                    state = ts.conn.prepareStatement(q);
                    state.setString(1, email);
                    ResultSet gebruikersType = state.executeQuery();

                    if (gebruikersType.next()) {
                        accountID = gebruikersType.getInt("ACCOUNT_ID");
                    }
                } catch (SQLException e) {
                    System.out.println(e.toString());
                } finally {
                    if (state != null) {
                        state.close();
                    }
                    dbhelp.verbindingverbrekenmetDatabase();
                }
            }
        } catch (IllegalAccessException ex) {
            
        }
        return accountID;
    }
    
}
