package Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Coen
 */
public class Fotograaf {
    private String naam;
    private int ID;
    private String bedrijf;
    private String postcode;

    public Fotograaf() {
    }
    
    public String getNaam(){
        return  this.naam;
    }
    
    public int getID(){
        return ID;
    }
    
    public String getBedrijf(){
        return  this.bedrijf;
    }
}
