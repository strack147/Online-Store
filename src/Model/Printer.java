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
public class Printer extends Product{
    private String type;
    private double glueSize;
    private String Interface;
    private String use;
    
    public Printer(String name, String code, double price,int quant,String typ, String type, double glueSize,
            String Interface, String use){
        super(name, code, price, quant,typ);
        this.type=type;
        this.glueSize=glueSize;
        this.Interface=Interface;
        this.use=use;
    }

    public String getType() {
        return type;
    }

    public double getGlueSize() {
        return glueSize;
    }

    public String getInterface() {
        return Interface;
    }

    public String getUse() {
        return use;
    }
    
    
}
