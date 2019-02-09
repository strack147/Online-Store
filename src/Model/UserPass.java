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
public class UserPass {
    public final String USERNAME="Default";
    public final String PASSWORD="Default";
    public double cash=0;
    
    
    private ArrayList<Entity> userList=new ArrayList<Entity>();
    private ArrayList<Product> productList=new ArrayList<>();
    private ArrayList<Product> userCart=new ArrayList<>();
    
    private  ArrayList<Order> orderList=new ArrayList<>();
    
    
    public void addOrder(Order order){
        orderList.add(order);
    }
    
    public Order getOrder(String code){
        for(Order x: orderList){
            if(x.getCode()==Integer.parseInt(code))
                return x;
        }
        return null;
    }
    public ArrayList<Product> getCartList(){
        return userCart;
    }
    
    public boolean isRightCode(String code){
        for(Product x: productList){
            if(x.getCode().equals(code))
                return true;
        }
        return false;
    }
    public void addToCart(Product x){
        userCart.add(x);
    }
    
    
    public Product getProduct(String code){
        for(Product x: productList){
            if(x.getCode().equals(code)){
                return x;
            }
        }
        return null;
    }
    public boolean removeProduct(String code){
        for(Product x: productList){
            if(x.getCode().equals(code)){
                productList.remove(x);
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Product> getProductList(){
        return this.productList;
    }
    public void addProduct(Product pro){
        productList.add(pro);
    }
    
    public ArrayList<Entity> getList(){
        return this.userList;
    }
    
    public void addUser(Entity user){
        this.userList.add(user);
    }
    
    public Entity getUser(String user, String pass){
        for(Entity x: userList){
            if(x.getUsername().equals(user)&& x.getPassword().equals(pass))
                return x;
        }
        return null;
    }

    public Product deleteFromCart(String code) {
        for(Product x: userCart){
            if(x.getCode().equals(code)){
                Product temp=x;
                userCart.remove(x);
                return temp;
            }
                
        }
        return null;
    }

    public void emptyCart() {
        userCart.clear();
    }

    public ArrayList<Order> getOrderList() {
        return this.orderList;
    }
}
