/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 *
 * @author tp3976,tp4248,tp4280,tp4304
 */
public class OrderTable extends JFrame{
 
    OrderPanel table=new OrderPanel();
    
    public OrderTable(Login log){
        super("Order Table");
                
        setLayout(new BorderLayout());
        table.setData(log.userPass.getOrderList());
        add(table,BorderLayout.CENTER);
    
        
        setSize(600,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
}
