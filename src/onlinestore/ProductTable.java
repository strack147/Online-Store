/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author tp3976,tp4248,tp4280,tp4304
 */
public class ProductTable extends JFrame{
 
    TablePanel table=new TablePanel();
    
    public ProductTable(Login log){
        super("Product Table");
                
        setLayout(new BorderLayout());
        table.setData(log.userPass.getProductList());
        add(table,BorderLayout.CENTER);
     
        
        
        
     
        
        
        
        
        setSize(600,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
}
