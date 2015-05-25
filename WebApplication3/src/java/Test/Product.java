package Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gebruiker
 */
public class Product {
    
    private double totalPrice;
    private int ID;
    private String Name;
    private String Description;
    private String Type;  
    private double Price;
    private int Quantity;
    private double TotalPrice;

    public Product(double totalPrice, int ID, String Name, String Description, String Type, double Price, int Quantity, double TotalPrice) {
        this.totalPrice = totalPrice;
        this.ID = ID;
        this.Name = Name;
        this.Description = Description;
        this.Type = Type;
        this.Price = Price;
        this.Quantity = Quantity;
        this.TotalPrice = TotalPrice;
    }
    
    public Product()
    {

    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }
    
        /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the Type
     */
    public String getType() {
        return Type;
    }

    /**
     * @param Type the Type to set
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    /**
     * @return the Price
     */
    public double getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(double Price) {
        this.Price = Price;
    }

    /**
     * @return the Quantity
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * @param Quantity the Quantity to set
     */
    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    /**
     * @return the TotalPrice
     */
    public double getTotalPrice() {
        this.totalPrice = this.Price * this.Quantity;
        return totalPrice;
    }

    /**
     * @param TotalPrice the TotalPrice to set
     */
    public void setTotalPrice(double TotalPrice) {
        this.totalPrice = TotalPrice;
    }
    
}
