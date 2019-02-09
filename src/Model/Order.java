/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author tp3976,tp4248,tp4280,tp4304
 */
public class Order {
    public ArrayList<Product> items;
    private String status="Pending";
    private int code;
    private double price;
    private static int orderCode=0;
    private String userName;
    private int Totalitems;
    public Order(String name){
        this.userName=name;
        this.code=++orderCode;
    }
    public Order(String name, int code, double price, int items){
        this.userName=name;
        this.code=code;
        this.price=price;
        this.Totalitems=items;
    }
    public String getUsername(){
        return userName;
    }
    public void setCode(int code){
        this.code=code;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return this.price;
    }
    public double getTotalPrice(){
        double sum=0;
        for(Product x: items){
            sum+=x.getPrice();
        }
        return sum;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public void setOrderItems(ArrayList<Product> list){
        items=list;
    }
    public int getTotalItems(){
        return this.Totalitems;
    }
    public void setItems(int item){
        this.Totalitems=item;
    }
    
    public String getStatus(){
        return status;
    }
    public int getCode(){
        return code;
    }
    public ArrayList<Product> getItems() {
        return items;
    }
    
    
    
}
