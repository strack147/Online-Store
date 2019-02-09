/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

import Model.Database;
import Model.Entity;
import Model.UserPass;

/**
 *
 * @author tp3976,tp4248,tp4280,tp4304
 */
public class OnlineStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database data=new Database();
        data.createUserTable();
        data.createProductTable();
        data.createOrderTable();
        
        
        UserPass userPass=new UserPass();
        data.getAllUsers(userPass);
        data.getAllProducts(userPass);
        data.getOrders(userPass);
        Login log=new Login(userPass, data);
        
    }
    
}
