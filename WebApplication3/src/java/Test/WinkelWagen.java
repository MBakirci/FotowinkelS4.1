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

    public WinkelWagen(ArrayList<Test.WinkelWagenItem> item) {
        itemlist = item;
    }

    public void NewList() {
        itemlist = new ArrayList<Test.WinkelWagenItem>();
    }

    public ArrayList<Test.WinkelWagenItem> GetWinkelWage() {
        return itemlist;
    }

    public String AantalItems() {
        if (itemlist != null) {
            return String.valueOf(itemlist.size());
        } else {
            return "0";
        }
    }

    public void DeleteItem(String fotocode, String product, String kleur, Integer xcor, Integer ycor, Integer wamnt, Integer hamnt) {
        Iterator<Test.WinkelWagenItem> it = itemlist.iterator();
        while (it.hasNext()) {
            Test.WinkelWagenItem item = it.next();
            if (item.getFotocode().equals(fotocode) && item.getProducttype().equals(product) && item.getKleurtype().equals(kleur) && item.getXcor() == xcor && item.getYcor() == ycor && item.getWamnt() == wamnt && item.getHamnt() == hamnt) {
                it.remove();
            }
        }
    }

    public void ChangeItem(String fotocode, int aantal, String product, String kleur, Integer xcor, Integer ycor, Integer wamnt, Integer hamnt) {
        Iterator<Test.WinkelWagenItem> it = itemlist.iterator();
        while (it.hasNext()) {
            Test.WinkelWagenItem item = it.next();
            if (item.getFotocode().equals(fotocode) && item.getProducttype().equals(product) && item.getKleurtype().equals(kleur) && item.getXcor() == xcor && item.getYcor() == ycor && item.getWamnt() == wamnt && item.getHamnt() == hamnt) {
                item.setAantal(aantal);
            }
        }
    }

    public ArrayList<Test.WinkelWagenItem> WinkelList() {
        return itemlist;
    }

    public void AddItem(String productnaam, Integer aantal, String kleurtype, String producttype, Double prijs, String fotocode, int X, int Y, int wid, int hei) {
        Test.WinkelWagenItem item = new Test.WinkelWagenItem(productnaam, aantal, kleurtype, producttype, prijs, fotocode, X, Y, wid, hei);

        int add = 0;
        if (itemlist.size() == 0) {
            itemlist.add(item);
        } else {
            for (Test.WinkelWagenItem es : itemlist) {
                if (productnaam.equals(es.getProductnaam()) && kleurtype.equals(es.getKleurtype()) && producttype.equals(es.getProducttype()) && X == es.getXcor() && Y == es.getYcor() && wid == es.getWamnt() && hei == es.getHamnt()) {
                    es.setAantal(es.getAantal() + aantal);
                    add = 1;
                }
            }
            if (add == 0) {
                itemlist.add(item);
            }
        }
    }

    public String getURLWithContextPath(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
