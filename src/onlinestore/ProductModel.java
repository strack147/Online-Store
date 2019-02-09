/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

import Model.Product;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tp3976,tp4248,tp4280,tp4304
 */
public class ProductModel extends AbstractTableModel{
    
    private String[] names={"Type","Name","Code","Price","Quantity"};
    private ArrayList<Product> list;
    
    public void setList(ArrayList<Product> list){
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
        Product x=list.get(rowIndex);
        
        
        switch(columnIndex){
            case 0:
                return x.getClass().getSimpleName();
            case 1:
                return x.getName();
            case 2:
                return x.getCode();
            case 3:
                return x.getPrice();
            case 4:
                return x.getQuantity();
        }
        return null;
    }
    
}
