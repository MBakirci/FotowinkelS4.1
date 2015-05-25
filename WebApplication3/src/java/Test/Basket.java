/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.sun.net.httpserver.HttpContext;
import java.util.*;

/**
 *
 * @author Gebruiker
 */
public class Basket {

    private Hashtable<String, Product> items = new Hashtable();
    private static Product tempProduct;

    public Basket() {
        items.clear();
    }

    public int CountItems() {
        if (items != null) {
            return items.size();
        }
        return 0;
    }

    public boolean Add(Product p) {
        if (!isNullOrEmpty(p.getName()) & !isNullOrEmpty(p.getType()) & p.getQuantity() > 0) {
            //Cast de key naar een temp product.
            tempProduct = items.get(p.getName() + p.getType());
            //Als hij al bestaat verhoog alleen het aantal.
            if (tempProduct != null) {
                tempProduct.setQuantity(tempProduct.getQuantity() + p.getQuantity());
            } //Mocht hij nog niet bestaan voeg hem toe aan de hashtable.
            else {
                items.put((p.getName() + p.getType()), p);
            }
            return true;
        }
        return false;
    }

    public boolean ChangeOrRemove(Product p) {
        if (!isNullOrEmpty(p.getName()) & !isNullOrEmpty(p.getType())) {
            tempProduct = items.get(p.getName() + p.getType());
            if (tempProduct != null) {
                if (tempProduct.getQuantity() > 0) {
                    p.setQuantity(tempProduct.getQuantity());
                } else {
                    items.remove(p.getName() + p.getType());
                    //if the Quantity = 0; The product removed from the Basket
                }
                return true;
            }
        }
        return false;
    }

    public boolean Delete(Product p) {
        p.setQuantity(0);
        ChangeOrRemove(p);
        return true;
    }

    public boolean change(Product p) {
        for (Product prod : items.values()) {
            if (prod.getName().equals(p.getName()) && prod.getType().equals(p.getType())) {
                p.setQuantity(prod.getQuantity());  //set Quantity 0 for deleting via ChangeOrRemove method
                ChangeOrRemove(prod);
                return true;
            }

        }
        return false;
    }

    public double TotalPrice() {
        //the total price of the basket;
        double total = 0.00;
        for (String k : items.keySet()) {
            Product p = items.get(k);
            total += p.getPrice() * p.getQuantity();
        }
        return total;
    }

    private static boolean isNullOrEmpty(String s) {
        return (s == null || s.trim().equals(""));
    }

}
