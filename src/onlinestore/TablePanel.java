/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

import Model.Product;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author tp3976,tp4248,tp4280,tp4304
 */
public class TablePanel extends JPanel{
    
    private ProductModel model;
    private JTable table;
    TablePanel(){
        model=new ProductModel();
        table=new JTable(model);
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
    
    public void setData(ArrayList<Product> list){
        model.setList(list);
    }
    public void refresh(){
        model.fireTableDataChanged();
    }
    
}
