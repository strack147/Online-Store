/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

import Model.Database;
import Model.Order;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author tp3976,tp4248,tp4280,tp4304
 */
public class User extends JFrame implements ActionListener{
    
    private JButton showProduct;
    private JButton disconnect;
    private JButton addToCart;
    private JButton delete;
    private JButton createNewOrder;
    private JButton viewOrderStatus;
    private JButton updateOrderStatus;
    private Login log;
    private Database data;
    
    User(Login log, Database data){
        super("Client");
        this.log=log;
        this.data=data;
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 35));
        
        
        showProduct=new JButton("Show Product");
        showProduct.addActionListener(this);
        add(showProduct);
        
        disconnect=new JButton("Disconnect");
        disconnect.addActionListener(this);
        add(disconnect);
        
        
        addToCart=new JButton("Add to Cart");
        addToCart.addActionListener(this);
        add(addToCart);
        
        
        delete=new JButton("Delete Product");
        delete.addActionListener(this);
        add(delete);
        
        createNewOrder=new JButton("Create New Order");
        createNewOrder.addActionListener(this);
        add(createNewOrder);
        
        viewOrderStatus=new JButton("View Order Status");
        viewOrderStatus.addActionListener(this);
        add(viewOrderStatus);
        
        updateOrderStatus=new JButton("Update Order Status");
        updateOrderStatus.addActionListener(this);
        add(updateOrderStatus);
        
          
        setSize(400,250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton x=(JButton)e.getSource();
        if(x==showProduct){
            new ProductTable(log);
        }
        if(x==disconnect){
            this.dispose();
            log.setVisible(true);
        }
        if(x==addToCart){
            String code=JOptionPane.showInputDialog("Enter Product Code");
            if(log.userPass.isRightCode(code)){
                log.userPass.addToCart(log.userPass.getProduct(code));
                JOptionPane.showMessageDialog(this, "Added to Cart");
            }
            else{
                JOptionPane.showMessageDialog(this, "Product Not in List");
            }
        }
        if(x==delete){
            String code=JOptionPane.showInputDialog("Enter Product Code");
            
            if(log.userPass.deleteFromCart(code)!=null){
                JOptionPane.showMessageDialog(this, "Product Removed From Cart");
            }
            else{
                JOptionPane.showMessageDialog(this, "Product Not in List");
            }
        }
        if(x==createNewOrder){
            log.userPass.emptyCart();
            JOptionPane.showMessageDialog(this, "New Cart Prepared for Order");
        }
        if(x==updateOrderStatus){
            String option=JOptionPane.showInputDialog("1)Confirm Order\n2)Cancel Order");
            if(option.equals("1")){
                String username=JOptionPane.showInputDialog("Enter Name to Parcell");
                Order order=new Order(username);
                order.setOrderItems(log.userPass.getCartList());
                
                
                log.userPass.addOrder(order);
                order.items=log.userPass.getCartList();
                order.setItems(order.items.size());
                order.setPrice(order.getTotalPrice());
                
                
                data.insertOrder(order);
                log.userPass.emptyCart();
                JOptionPane.showMessageDialog(this, "Order Confirmed\n Order Code:"+order.getCode());
            }
            else if(option.equals("2")){
                log.userPass.emptyCart();
                JOptionPane.showMessageDialog(this, "Order Cleared");
            }
            else{
            JOptionPane.showMessageDialog(this, "Wrong Choice Made");
        }
            
        
        }
        if(x==viewOrderStatus){
            String code=JOptionPane.showInputDialog("Enter Order Code");
            Order order=log.userPass.getOrder(code);
            if(order!=null){
                JOptionPane.showMessageDialog(this, "Order is: "+order.getStatus());
            }
            else{
                JOptionPane.showMessageDialog(this, "No Order Found with Code:"+code);
            }
        }
        
    }
}
