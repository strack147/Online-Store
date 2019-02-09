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
public class TV extends Product{
    
    private String company;
    private String screenSize;
    
    public TV(String name, String code, double cost,int quant,String type, String company, String screen){
        super(name, code, cost, quant,type);
        this.company=company;
        this.screenSize=screenSize;
    }
}
