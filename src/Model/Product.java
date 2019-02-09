/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author tp3976,tp4248,tp4280,tp4304
 */
public class Product {

    private String name;
    private String code;
    private double price;
    private int quantity;
    private String type;
    
    public Product(String name, String code, double price, int quantity,String type){
        this.name=name;
        this.code=code;
        this.price=price;
        this.quantity=quantity;
        this.type=type;
    }
    
    public String getType(){
        return this.type;
    }
    public int getQuantity(){
        return this.quantity;
    }
    
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }
    
}
