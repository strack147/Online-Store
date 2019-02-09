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
public class Computer extends Product{
    
    private String processor;
    private String graphicsCard;
    private String monitor;
    private String operatingSystem;
    private String memory;
    
    public Computer(String name, String code, double price,int quant,String type, String processor, String graphicsCard,
            String monitor, String os, String memory){
        super(name, code, price, quant,type);
        this.processor=processor;
        this.graphicsCard=graphicsCard;
        this.monitor=monitor;
        this.operatingSystem=os;
        this.memory=memory;
    }

    public String getProcessor() {
        return processor;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public String getMonitor() {
        return monitor;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getMemory() {
        return memory;
    }
    
    
    
}
