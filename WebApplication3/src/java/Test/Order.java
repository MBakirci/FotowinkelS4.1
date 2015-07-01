/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author asror
 */
public class Order {
    
    String prijs;
    String valuta;
    String bestellingid;
    String datum;
    
    public String getPrijs() {
        return prijs;
    }

    public void setPrijs(String prijs) {
        this.prijs = prijs;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public String getBestellingid() {
        return bestellingid;
    }

    public void setBestellingid(String bestellingid) {
        this.bestellingid = bestellingid;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Order(String prijs, String valuta, String bestellingid, String datum) {
        this.prijs = prijs;
        this.valuta = valuta;
        this.bestellingid = bestellingid;
        this.datum = datum;
    }
    
    
}
