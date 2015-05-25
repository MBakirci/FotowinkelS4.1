/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dennis
 */
public class Photo {
    
    public ArrayList<String> myNumbers()    
    {
    ArrayList<String> numbers = new ArrayList<String>();
    numbers.add("http://i.imgur.com/Ap5WXqh.jpg");
    numbers.add("http://i.imgur.com/wX4xppA.jpg");
    numbers.add("http://i.imgur.com/3cL9JSA.jpg");
    return(numbers);
    }
    
    public ArrayList getPhotos(String usernameString) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        if(isPhotographer(usernameString))
        {
            return getPhotosPhotographer(usernameString);
        }
        else //it is a customer
        {
            return getPhotosCustomer(usernameString);
        }
    }
    
    public ArrayList<String> getCategoriesPhotographer (String usernameString) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException
    {
        ArrayList categoryList = new ArrayList();
        Test.Databaseconnector ts = new Test.Databaseconnector();
        String fotograafID = getID(usernameString);
        
        if(ts.verbindmetDatabase())
        {       
        PreparedStatement state = null;
            try {
                    //Update gebruiker gedeelte van fotograaf
                    String q = "SElECT NAAM FROM FW_CATEGORIE where FOTOGRAAFID = ?";
                    state = ts.conn.prepareStatement(q);
                    state.setString(1, fotograafID);
                    ResultSet rs = state.executeQuery();

                    while (rs.next()) {
                        String naam = rs.getString("NAAM");
                        categoryList.add(naam);
                    }
                    return categoryList;
                } catch (SQLException e) {
                    System.out.println(e.toString());
                } finally {
                    if (state != null) {
                        state.close();
                    }
        }
        }
        return null;
    }
    
    public String getCategoryID(String photosCategory) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException
    {
        String catID = "";
        Test.Databaseconnector ts = new Test.Databaseconnector();
        
        if (ts.verbindmetDatabase()) {
                PreparedStatement state = null;
                
                try {
                    //Update gebruiker gedeelte van fotograaf
                    String q = "SElECT CATEGORIE_ID FROM FW_CATEGORIE where NAAM = ?";
                    state = ts.conn.prepareStatement(q);
                    state.setString(1, photosCategory);
                    ResultSet rs = state.executeQuery();

                    if (rs.next()) {
                        catID = rs.getString("CATEGORIE_ID");
                    }
                    return catID;
                } catch (SQLException e) {
                    System.out.println(e.toString());
                } finally {
                    if (state != null) {
                        state.close();
                    }
                }              
        }
        return null;
    }
    
    public ArrayList<String> getPhotosCategory(String photosCategory) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException
    {
        ArrayList photoList = new ArrayList();
        Test.Databaseconnector ts = new Test.Databaseconnector();
        String catID = getCategoryID(photosCategory);
        
        if (ts.verbindmetDatabase()) {
                PreparedStatement state = null;
                
                try {
                    //Update gebruiker gedeelte van fotograaf
                    String q = "SElECT FILEPATH FROM FW_FOTO where CATID = ?";
                    state = ts.conn.prepareStatement(q);
                    state.setString(1, catID);
                    ResultSet rs = state.executeQuery();

                    while (rs.next()) {
                        String filepathString = rs.getString("FILEPATH");
                        String thumbPath = filepathString.substring(filepathString.lastIndexOf("/"));
                        photoList.add("ftp://212.64.126.219:9942/Thumb" + thumbPath );
                    }
                    return photoList;
                } catch (SQLException e) {
                    System.out.println(e.toString());
                } finally {
                    if (state != null) {
                        state.close();
                    }
                }              
        }
        return null;
    }
    
    public ArrayList<String> getPhotosPhotographer(String usernameString) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException
    {
        ArrayList photoList = new ArrayList();
        Test.Databaseconnector ts = new Test.Databaseconnector();
        String fotograafID = getID(usernameString); // moet nog method voor komen
        
        
        if (ts.verbindmetDatabase()) {
                PreparedStatement state = null;
                
                try {
                    //Update gebruiker gedeelte van fotograaf
                    String q = "SElECT FILEPATH FROM FW_FOTO where FOTOGRAAFID = ?";
                    state = ts.conn.prepareStatement(q);
                    state.setString(1, fotograafID);
                    ResultSet rs = state.executeQuery();

                    while (rs.next()) {
                        String filepathString = rs.getString("FILEPATH");
                        String thumbPath = filepathString.substring(filepathString.lastIndexOf("/"));
                        photoList.add("ftp://212.64.126.219:9942/Thumb" + thumbPath );
                    }
                    return photoList;
                } catch (SQLException e) {
                    System.out.println(e.toString());
                } finally {
                    if (state != null) {
                        state.close();
                    }
                }              
        }
        return null;
    }
    public ArrayList<String> getPhotosCustomer(String usernameString) throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException
    {
        ArrayList photoList = new ArrayList();
        Test.Databaseconnector ts = new Test.Databaseconnector();
        String klantID = getID(usernameString); // moet nog method voor komen
        
        
        if (ts.verbindmetDatabase()) {
                PreparedStatement state = null;
                
                try {
                    //Update gebruiker gedeelte van fotograaf
                    String q = "SELECT FILEPATH FROM FW_FOTO where UNIQUECODE IN (SELECT FOTOCODE FROM FW_KLANT_FOTO where KLANTID = ?)";
                    state = ts.conn.prepareStatement(q);
                    state.setString(1, klantID);
                    ResultSet rs = state.executeQuery();

                    while (rs.next()) {
                        String filepathString = rs.getString("FILEPATH");
                        String thumbPath = filepathString.substring(filepathString.lastIndexOf("/"));
                        photoList.add("ftp://212.64.126.219:9942/Thumb" + thumbPath);
                    }
                    return photoList;
                } catch (SQLException e) {
                    System.out.println(e.toString());
                } finally {
                    if (state != null) {
                        state.close();
                    }
                }              
        }
        return null;
    }
    
    public boolean isPhotographer(String email) throws SQLException, ClassNotFoundException, InstantiationException
    {
         boolean photographer = false;
         String userType = "";
         
        Test.Databaseconnector ts = new Test.Databaseconnector();
        try {
            if (ts.verbindmetDatabase()) {
                PreparedStatement state = null;
                try {
                    //Update gebruiker gedeelte van fotograaf
                    String q = "SELECT ATYPE from FW_ACCOUNT where EMAIL=?";
                    state = ts.conn.prepareStatement(q);
                    state.setString(1, email);
                    ResultSet gebruikersType = state.executeQuery();

                    if (gebruikersType.next()) {
                        userType = gebruikersType.getString("ATYPE");
                    }
                } catch (SQLException e) {
                    System.out.println(e.toString());
                } finally {
                    if (state != null) {
                        state.close();
                    }
                }
                if(userType.equals("fotograaf"))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return photographer;
    }
    
    public String getID(String email) throws ClassNotFoundException, InstantiationException, SQLException
    {

         String accountID = "";
         
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
                        accountID = gebruikersType.getString("ACCOUNT_ID");
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
        return accountID;
    }
    
}
