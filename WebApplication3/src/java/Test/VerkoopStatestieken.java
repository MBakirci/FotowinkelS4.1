/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author Coen
 */
public class VerkoopStatestieken {
    public static HashMap<String, Object> TotaalVerkoop(){
        //Select p.NAAM, SUM(b.Aantal * p.Prijs) as opbrengst
        //From FW_BESTELLING b, FW_PRODUCT p
        //Where b.PRODUCTID = p.PRODUCTID
        //group by p.NAAM;
        return null;
    }
    
    public static HashMap<String, Object> MaandVerkoop(Calendar maand){
        return null;
    }
    
    public static HashMap<String, Object> CostumeRangeVerkoop(Calendar dag1, Calendar dag2){
        return null;
    }
    
    public static HashMap<String, Object> FotograafVerkoop(User user){
        HashMap<String, Object> result = FotograafVerkoop(user.geteMail());
        return result;
    }
    
    public static HashMap<String, Object> FotograafVerkoop(String email){
        return null;
    }
    
    public static HashMap<String, Object> VerkoopFoto(String code){
        return null;
    }
    
    public static HashMap<String, Object> VerkoopItem(int ProductID){
        //Select p.NAAM, SUM(b.Aantal * p.Prijs) as opbrengst
        //From FW_BESTELLING b, FW_PRODUCT p
        //Where b.PRODUCTID = p.PRODUCTID
        //and p.PRODUCTID = :ProductID
        //group by p.NAAM;
        return null;
    }
}
