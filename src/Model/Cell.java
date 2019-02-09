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
public class Cell extends Product{
    private String operatingSystem;
    private String processor;
    private String display;
    private String camera;
    private String color;
    private String wireless;
    
    
    public Cell(String name, String code, double price,int quant,String type,String os, String processor,
            String display, String camera, String color, String wireless){
        super(name, code, price,quant,type);
        this.operatingSystem=os;
        this.processor=processor;
        this.display=display;
        this.camera=camera;
        this.color=color;
        this.wireless=wireless;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getProcessor() {
        return processor;
    }

    public String getDisplay() {
        return display;
    }

    public String getCamera() {
        return camera;
    }

    public String getColor() {
        return color;
    }

    public String isWireless() {
        return wireless;
    }
    
    
}
