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
public class HeadPhones extends Product{
    
    private String company;
    
    public HeadPhones(String name, String code, double price, int quantity,String type,String company){
        super(name, code, price, quantity,type);
        this.company=company;
    }

    public String getCompany() {
        return company;
    }
    
}
