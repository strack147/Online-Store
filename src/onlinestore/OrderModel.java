/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

import Model.Order;
import Model.Product;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tp3976,tp4248,tp4280,tp4304
 */
public class OrderModel extends AbstractTableModel{
    
    private String[] names={"Username","Code","Status","No.Of Items","Total Price"};
    private ArrayList<Order> list;
    
    public void setList(ArrayList<Order> list){
        this.list=list;
    }

    @Override
    public int getRowCount() {
       return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        return names[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Order x=list.get(rowIndex);
        
        
        switch(columnIndex){
            case 0:
                return x.getUsername();
            case 1:
                return x.getCode();
            case 2:
                return x.getStatus();
            case 3:
                return x.getTotalItems();
            case 4:
                return x.getPrice();
        }
        return null;
    }
    
}