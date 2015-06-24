/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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

    public ArrayList<Test.WinkelWagenItem> GetWinkelWageValuta(String valuta) {
        ArrayList<Test.WinkelWagenItem> itemvallist = new ArrayList<Test.WinkelWagenItem>();
        Iterator<Test.WinkelWagenItem> it = itemlist.iterator();
        while (it.hasNext()) {
            Test.WinkelWagenItem item = it.next();
            Double value = item.getPrijs() * 1 / getRates("EUR");
            Double rates;
            if (valuta != null) {
                rates = getRates(valuta);
            } else {
                rates = getRates("EUR");
            }
            value = value * rates;
            Test.WinkelWagenItem itemval = new Test.WinkelWagenItem(item.getProductnaam(), item.getAantal(), item.getKleurtype(), item.getProducttype(), value, item.getFotocode(), item.getXcor(), item.getYcor(), item.getWamnt(), item.getHamnt());
            itemvallist.add(itemval);

        }

        return itemvallist;
    }

    public Double getRates(String valuta) {
        Map<String, Double> myMap = new HashMap<String, Double>();
        {
            myMap.put("AFN", 59.774267);
            myMap.put("ALL", 126.575901);
            myMap.put("AMD", 478.575997);
            myMap.put("ANG", 1.78946);
            myMap.put("AOA", 109.706876);
            myMap.put("ARS", 8.977545);
            myMap.put("AUD", 1.278006);
            myMap.put("AWG", 1.79);
            myMap.put("AZN", 1.049);
            myMap.put("BAM", 1.77172);
            myMap.put("BBD", 2.0);
            myMap.put("BDT", 77.85141);
            myMap.put("BGN", 1.772547);
            myMap.put("BHD", 0.377078);
            myMap.put("BIF", 1577.736733);
            myMap.put("BMD", 1.0);
            myMap.put("BND", 1.33547);
            myMap.put("BOB", 6.909797);
            myMap.put("BRL", 3.078451);
            myMap.put("BSD", 1.0);
            myMap.put("BTC", 0.0041601128);
            myMap.put("BTN", 63.559884);
            myMap.put("BWP", 9.735394);
            myMap.put("BYR", 14301.5);
            myMap.put("BZD", 1.997916);
            myMap.put("CAD", 1.226416);
            myMap.put("CDF", 924.7685);
            myMap.put("CHF", 0.941803);
            myMap.put("CLF", 0.024598);
            myMap.put("CLP", 607.508696);
            myMap.put("CNY", 6.177826);
            myMap.put("COP", 2492.463359);
            myMap.put("CRC", 531.650999);
            myMap.put("CUC", 1.0);
            myMap.put("CUP", 1.000175);
            myMap.put("CVE", 99.295638);
            myMap.put("CZK", 24.85117);
            myMap.put("DJF", 177.2074);
            myMap.put("DKK", 6.757952);
            myMap.put("DOP", 44.84724);
            myMap.put("DZD", 99.21663);
            myMap.put("EEK", 14.13795);
            myMap.put("EGP", 7.630543);
            myMap.put("ERN", 15.1151);
            myMap.put("ETB", 20.56094);
            myMap.put("EUR", 0.908049);
            myMap.put("FJD", 2.044258);
            myMap.put("FKP", 0.645584);
            myMap.put("GBP", 0.645584);
            myMap.put("GEL", 2.271925);
            myMap.put("GGP", 0.645584);
            myMap.put("GHS", 4.015925);
            myMap.put("GIP", 0.645584);
            myMap.put("GMD", 43.04283);
            myMap.put("GNF", 7315.735);
            myMap.put("GTQ", 7.66918);
            myMap.put("GYD", 206.169502);
            myMap.put("HKD", 7.752065);
            myMap.put("HNL", 21.92292);
            myMap.put("HRK", 6.83173);
            myMap.put("HTG", 47.80382);
            myMap.put("HUF", 278.2409);
            myMap.put("IDR", 13150.966667);
            myMap.put("ILS", 3.883392);
            myMap.put("IMP", 0.645584);
            myMap.put("INR", 63.5257);
            myMap.put("IQD", 1182.059192);
            myMap.put("IRR", 28388.667967);
            myMap.put("ISK", 133.509001);
            myMap.put("JEP", 0.645584);
            myMap.put("JMD", 115.921001);
            myMap.put("JOD", 0.7084);
            myMap.put("JPY", 121.452601);
            myMap.put("KES", 97.14057);
            myMap.put("KGS", 58.538934);
            myMap.put("KHR", 4069.997217);
            myMap.put("KMF", 445.364915);
            myMap.put("KPW", 899.91);
            myMap.put("KRW", 1093.94999);
            myMap.put("KWD", 0.302248);
            myMap.put("KYD", 0.823786);
            myMap.put("KZT", 186.025599);
            myMap.put("LAK", 8090.973398);
            myMap.put("LBP", 1507.841667);
            myMap.put("LKR", 133.7617);
            myMap.put("LRD", 84.553335);
            myMap.put("LSL", 11.87897);
            myMap.put("LTL", 2.9336);
            myMap.put("LVL", 0.636062);
            myMap.put("LYD", 1.366388);
            myMap.put("MAD", 9.794189);
            myMap.put("MDL", 17.9019);
            myMap.put("MGA", 3163.181683);
            myMap.put("MKD", 55.87613);
            myMap.put("MMK", 1088.025019);
            myMap.put("MNT", 1933.833333);
            myMap.put("MOP", 7.976216);
            myMap.put("MRO", 312.509);
            myMap.put("MTL", 0.389864);
            myMap.put("MUR", 35.10606);
            myMap.put("MVR", 15.286925);
            myMap.put("MWK", 440.882799);
            myMap.put("MXN", 15.2485);
            myMap.put("MYR", 3.598672);
            myMap.put("MZN", 36.85);
            myMap.put("NAD", 11.87897);
            myMap.put("NGN", 199.075001);
            myMap.put("NIO", 26.90637);
            myMap.put("NOK", 7.629494);
            myMap.put("NPR", 101.6767);
            myMap.put("NZD", 1.368101);
            myMap.put("OMR", 0.384967);
            myMap.put("PAB", 1.0);
            myMap.put("PEN", 3.143815);
            myMap.put("PGK", 2.712122);
            myMap.put("PHP", 44.58946);
            myMap.put("PKR", 101.923701);
            myMap.put("PLN", 3.720244);
            myMap.put("PYG", 5076.983359);
            myMap.put("QAR", 3.640251);
            myMap.put("RON", 4.035782);
            myMap.put("RSD", 109.3292);
            myMap.put("RUB", 49.96657);
            myMap.put("RWF", 690.7275);
            myMap.put("SAR", 3.750527);
            myMap.put("SBD", 7.719316);
            myMap.put("SCR", 13.4409);
            myMap.put("SDG", 5.9725);
            myMap.put("SEK", 8.379995);
            myMap.put("SGD", 1.336456);
            myMap.put("SHP", 0.645584);
            myMap.put("SLL", 4315.0);
            myMap.put("SOS", 698.250002);
            myMap.put("SRD", 3.313667);
            myMap.put("STD", 22118.966667);
            myMap.put("SVC", 8.747366);
            myMap.put("SYP", 188.809498);
            myMap.put("SZL", 11.87797);
            myMap.put("THB", 33.48248);
            myMap.put("TJS", 6.280133);
            myMap.put("TMT", 3.499733);
            myMap.put("TND", 1.955027);
            myMap.put("TOP", 2.02609);
            myMap.put("TRY", 2.595159);
            myMap.put("TTD", 6.351445);
            myMap.put("TWD", 30.46415);
            myMap.put("TZS", 2047.436699);
            myMap.put("UAH", 20.75108);
            myMap.put("UGX", 3001.963333);
            myMap.put("USD", 1.0);
            myMap.put("UYU", 26.72912);
            myMap.put("UZS", 2522.463359);
            myMap.put("VEF", 6.318864);
            myMap.put("VND", 21806.666667);
            myMap.put("VUV", 104.826667);
            myMap.put("WST", 2.473369);
            myMap.put("XAF", 593.190726);
            myMap.put("XAG", 0.05858319);
            myMap.put("XAU", 0.00082902);
            myMap.put("XCD", 2.70102);
            myMap.put("XDR", 0.71321);
            myMap.put("XOF", 592.282166);
            myMap.put("XPF", 108.246269);
            myMap.put("YER", 215.019499);
            myMap.put("ZAR", 11.87908);
            myMap.put("ZMK", 5253.075255);
            myMap.put("ZMW", 7.126316);
            myMap.put("ZWL", 322.355006);
        }
        
        Double rate = myMap.get(valuta);
        
        return rate;
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
                Test.WinkelWagenItem item;
        if (X != 0 && Y != 0 && wid != 0 && hei != 0) {
             item = new Test.WinkelWagenItem(productnaam, aantal, kleurtype, producttype, prijs, fotocode, X, Y, wid, hei);
        } else {
             item = new Test.WinkelWagenItem(productnaam, aantal, kleurtype, producttype, prijs, fotocode , X, Y, wid, hei);

        }

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
