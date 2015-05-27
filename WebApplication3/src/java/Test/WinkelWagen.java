/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author asror
 */
public class WinkelWagen {

    static ArrayList<Test.WinkelWagenItem> itemlist = new ArrayList<Test.WinkelWagenItem>();

    public WinkelWagen() {

    }

    public void NewList(List<Test.WinkelWagenItem> item) {
        itemlist = new ArrayList<Test.WinkelWagenItem>();
    }

    public ArrayList<Test.WinkelWagenItem> GetWinkelWage()
    {
        return itemlist;
    }
    
    
    public String AantalItems() {
        if (itemlist != null) {
            return String.valueOf(itemlist.size());
        } else {
            return "0";
        }
    }

    public void DeleteItem(String fotocode) {
        Iterator<Test.WinkelWagenItem> it = itemlist.iterator();
        while (it.hasNext()) {
            Test.WinkelWagenItem item = it.next();
            if (item.getFotocode().equals(fotocode)) {
                it.remove();
            }
        }
    }

    public void ChangeItem(String fotocode, int aantal)
    {
        Iterator<Test.WinkelWagenItem> it = itemlist.iterator();
        while (it.hasNext()) {
            Test.WinkelWagenItem item = it.next();
            if (item.getFotocode().equals(fotocode)) {
                item.setAantal(aantal);
            }
        }
    }
    
    
    public ArrayList<Test.WinkelWagenItem> WinkelList() {
        return itemlist;
    }

    public void AddItem(String productnaam, Integer aantal, String kleurtype, String producttype, Double prijs, String fotocode) {
        Test.WinkelWagenItem item = new Test.WinkelWagenItem(productnaam, aantal, kleurtype, producttype, prijs, fotocode);
if(itemlist.size() == 0)
        {
            itemlist.add(item);
        }
        else
        {
        for (Test.WinkelWagenItem es : itemlist) {
            if(productnaam.equals(es.getProductnaam()) && kleurtype.equals(es.getKleurtype()) && producttype.equals(es.getProducttype()))
            {
            es.setAantal(es.getAantal() + aantal);
            }
            else
            {
               itemlist.add(item); 
            }
        }

        }
        }
    
    public String getURLWithContextPath(HttpServletRequest request) {
    return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
