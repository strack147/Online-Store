/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

import Model.Cell;
import Model.Computer;
import Model.Database;
import Model.Entity;
import Model.HeadPhones;
import Model.Order;
import Model.Printer;
import Model.Product;
import Model.Refrigirator;
import Model.TV;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Model.Type;
/**
 *
 * @author tp3976,tp4248,tp4280,tp4304
 */
public class Administrator extends JFrame implements ActionListener {
    
    private JButton createUser;
    private JButton disconnect;
    private JButton showCatalog;
    private JButton addProduct;
    private JButton removeProduct;
    private JButton updateProduct;
    private JButton updateOrderStatus;
    private JButton presentationClientele;
    private JButton presentOrder;
    private JButton calculationTurnOver;
    private Login log;
    private Database data;
    
    
    Administrator(Login log, Database data){
        super("Administrator Menu");
        setLayout(new GridBagLayout());
        this.log=log;
        this.data=data;
        presentationClientele=new JButton("Presentation Clientele");
        updateOrderStatus=new JButton("Update Order Status");
        
        GridBagConstraints gc=new GridBagConstraints();
        
        gc.insets=new Insets(0,60,0,0);
        gc.anchor=GridBagConstraints.LINE_END;
        gc.weightx=1;
        gc.weighty=2;
        //first Row
        gc.gridx=0;
        gc.gridy=0;
        createUser=new JButton("Create User");
        createUser.addActionListener(this);
        
        add(createUser, gc);
        //gc.insets=new Insets(0,0,0,0);
        gc.gridx++;
        gc.anchor=GridBagConstraints.LINE_START;
        disconnect=new JButton("Disconnect");
        disconnect.addActionListener(this);
        add(disconnect, gc);
        
        //next Row
        gc.anchor=GridBagConstraints.LINE_END;
        gc.gridx=0;
        gc.gridy++;
        showCatalog=new JButton("Show Catalog");
        showCatalog.addActionListener(this);
        add(showCatalog, gc);
        
        gc.gridx++;
        gc.anchor=GridBagConstraints.LINE_START;
        addProduct=new JButton("Add Product");
        addProduct.addActionListener(this);
        add(addProduct, gc);
        
        //next Row
        gc.anchor=GridBagConstraints.LINE_END;
        gc.gridx=0;
        gc.gridy++;
        removeProduct=new JButton("Remove Product");
        removeProduct.addActionListener(this);
        add(removeProduct, gc);
        
        gc.gridx++;
        gc.anchor=GridBagConstraints.LINE_START;
        updateProduct=new JButton("Update Product");
        updateProduct.addActionListener(this);
        add(updateProduct, gc);
        
        //next Row
        gc.anchor=GridBagConstraints.LINE_END;
        gc.gridx=0;
        gc.gridy++;
        
        updateOrderStatus.addActionListener(this);
        add(updateOrderStatus, gc);
        
        gc.gridx++;
        gc.anchor=GridBagConstraints.LINE_START;
        presentationClientele.addActionListener(this);
        add(presentationClientele, gc);
        
        
        //next Row
        gc.anchor=GridBagConstraints.LINE_END;
        gc.gridx=0;
        gc.gridy++;
        presentOrder=new JButton("Present Order");
        presentOrder.addActionListener(this);
        add(presentOrder, gc);
        
        gc.gridx++;
        gc.anchor=GridBagConstraints.LINE_START;
        calculationTurnOver=new JButton("Calculation TurnOver");
        calculationTurnOver.addActionListener(this);
        add(calculationTurnOver, gc);
        
        
        
        
        
        
        
        
        
        
        
        setSize(600,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn=(JButton)e.getSource();
        if(btn==disconnect){
            this.dispose();
            log.setVisible(true);
        }
        if(btn==updateOrderStatus){
            String code=JOptionPane.showInputDialog("Enter Order Code");
            Order order=log.userPass.getOrder(code);
            if(order!=null){
                data.updateOrder(order);
                order.setStatus("Delivered");
                JOptionPane.showMessageDialog(this, "Order Updated");
            }
            else{
                JOptionPane.showMessageDialog(this, "Order Not Found with This Code");
            }
        }
        if(btn==presentationClientele){
            ShowAllUsersGui show = new ShowAllUsersGui();
        }
        if(btn==calculationTurnOver){
            log.userPass.cash=0;
            for(Order x: log.userPass.getOrderList()){
                if(x.getStatus().equalsIgnoreCase("DELIVERED")){
                    log.userPass.cash+=x.getPrice();
                }
            }
            
            JOptionPane.showMessageDialog(this, "Total Income:"+log.userPass.cash);
        }
        if(btn==presentOrder){
            new OrderTable(log);
        }
        if(btn==createUser){
            String username=JOptionPane.showInputDialog(this, "Enter New Username:", "Create User", JOptionPane.OK_CANCEL_OPTION);
            String password=JOptionPane.showInputDialog(this, "Enter Password:", "Create User", JOptionPane.OK_CANCEL_OPTION);
            String type=JOptionPane.showInputDialog(this, "1)User\n2)Administrator:", "Create User", JOptionPane.OK_CANCEL_OPTION);
            Model.Type typ=type.equals("1")?Model.Type.CUSTOMER:Model.Type.ADMINISTRATOR;
            
            log.userPass.addUser(new Entity(username, password, typ));
            data.insertUser(new Entity(username, password, typ));
            JOptionPane.showMessageDialog(this, "User Added Successfully");
        }
        if(btn==showCatalog){
            new ProductTable(log);
        }
        if(btn==removeProduct){
            String code=JOptionPane.showInputDialog("Enter Product Code");
            if(log.userPass.removeProduct(code)){
                data.deleteProduct(code);
                JOptionPane.showMessageDialog(this, "Product Removed Successfully");
            }
            else{
                JOptionPane.showMessageDialog(this, "Product Not Found");
            }
        }
        if(btn==updateProduct){
            String code=JOptionPane.showInputDialog("Enter Product Code");
            Product x=log.userPass.getProduct(code);
            Product xx;
            if(log.userPass.removeProduct(code)){
                switch(x.getType()){
                case "Computer":
                    xx=getComputer();
                    data.updateProduct(log.userPass, xx,code);
                    log.userPass.addProduct(xx);
                    
                    
                    break;
                case "Cell":
                    xx=getCell();
                    data.updateProduct(log.userPass, xx,code);
                    log.userPass.addProduct(xx);
                    break;
                case "HeadPhones":
                    xx=getHeadPhone();
                    data.updateProduct(log.userPass, xx,code);
                    log.userPass.addProduct(xx);
                    break;
                    
                case "Printer":
                    xx=getPrinter();
                    data.updateProduct(log.userPass, xx,code);
                    log.userPass.addProduct(xx);
                    break;
                    
                case "Refrigirator":
                    xx=getRefrigirator();
                    data.updateProduct(log.userPass, xx,code);
                    log.userPass.addProduct(xx);
                    break;
                case "TV":
                    xx=getTV();
                    data.updateProduct(log.userPass, xx,code);
                    log.userPass.addProduct(xx);
                    break;
                }
                
                JOptionPane.showMessageDialog(this, "Product Updated Successfully");
            }
            else{
                JOptionPane.showMessageDialog(this, "Product Not Found");
            }
        }
        if(btn==addProduct){
            Product x;
            String choice=getProductChoice();
            switch(choice){
                case "1":
                    x=getComputer();
                    data.insertProduct(x);
                    log.userPass.addProduct(x);
                    
                    JOptionPane.showMessageDialog(this, "Product Added");
                    break;
                case "2":
                    x=getCell();
                    data.insertProduct(x);
                    log.userPass.addProduct(x);
                    JOptionPane.showMessageDialog(this, "Product Added");
                    break;
                case "3":
                    x=getPrinter();
                    data.insertProduct(x);
                    log.userPass.addProduct(x);
                    JOptionPane.showMessageDialog(this, "Product Added");
                    break;
                case "4":
                    x=getHeadPhone();
                    data.insertProduct(x);
                    log.userPass.addProduct(x);
                    JOptionPane.showMessageDialog(this, "Product Added");
                    break;
                case "5":
                    x=getRefrigirator();
                    data.insertProduct(x);
                    log.userPass.addProduct(x);
                    JOptionPane.showMessageDialog(this, "Product Added");
                    break;
                case "6":
                    x=getTV();
                    data.insertProduct(x);
                    log.userPass.addProduct(x);
                    JOptionPane.showMessageDialog(this, "Product Added");
                    break;
                default:
                {
                    JOptionPane.showMessageDialog(this, "Wrong Choice Entered");
                    return;
                }
                
            }
            
        }
    }
    private String getProductChoice() {
        String option="1)Computer\n2)Cell\n3)Printer\n4)HeadPhones\n5)Refrigirator\n6)TV";
        return JOptionPane.showInputDialog(option);
    }

    private Product getComputer() {
       String basics= getBasics();
       String[] comp=basics.split(",");
       //processor, monitor, card, memory
       String processor=JOptionPane.showInputDialog("Enter Processor");
       String monitor=JOptionPane.showInputDialog("Enter Monitor");
       String card=JOptionPane.showInputDialog("Enter Graphics Card");
       String memory=JOptionPane.showInputDialog("Enter Memory");
       String os=JOptionPane.showInputDialog("Enter Operating System");
       
       return new Computer(comp[0],comp[1],Double.parseDouble(comp[2]), Integer.parseInt(comp[3]),Computer.class.getSimpleName(),
       processor,card, monitor, os, memory);
    }
    private String getBasics(){
        String basics="";
        basics+=JOptionPane.showInputDialog("Enter Name");
        basics+=","+JOptionPane.showInputDialog("Enter Code");
        basics+=","+JOptionPane.showInputDialog("Enter Price");
        basics+=","+JOptionPane.showInputDialog("Enter Quantity");
        
        return basics;
    }

    private Product getCell() {
       String basics= getBasics();
       String[] comp=basics.split(",");
       //display, camera, wireless
       String processor=JOptionPane.showInputDialog("Enter Processor");
       String display=JOptionPane.showInputDialog("Enter Display");
       String camera=JOptionPane.showInputDialog("Enter Camera");
       String wireless=JOptionPane.showInputDialog("Enter wireless");
       String os=JOptionPane.showInputDialog("Enter Operating System");
       String color=JOptionPane.showInputDialog("Enter Color");
       return new Cell(comp[0],comp[1],Double.parseDouble(comp[2]), Integer.parseInt(comp[3]),Cell.class.getSimpleName(),
        os, processor, display,camera, color, wireless);
    }

    private Product getPrinter() {
        String basics= getBasics();
        String[] comp=basics.split(",");
                
                //type, size, interface, use
       String type=JOptionPane.showInputDialog("Enter type");
       String Interface=JOptionPane.showInputDialog("Enter Interface");
       double glueSize=Double.parseDouble(JOptionPane.showInputDialog("Enter Glue Size"));
       
       String use=JOptionPane.showInputDialog("Enter Use");
           
        return new Printer(comp[0],comp[1],Double.parseDouble(comp[2]), Integer.parseInt(comp[3]),Printer.class.getSimpleName(),
        type, glueSize, Interface, use);
    }

    private Product getHeadPhone() {
        String basics= getBasics();
        String[] comp=basics.split(",");
        
        String company=JOptionPane.showInputDialog("Enter Company Name");
        return new HeadPhones(comp[0],comp[1],Double.parseDouble(comp[2]), Integer.parseInt(comp[3]),HeadPhones.class.getSimpleName(),
        company);
        
    }

    private Product getRefrigirator() {
        String basics= getBasics();
        String[] comp=basics.split(",");
       String company=JOptionPane.showInputDialog("Enter Company");
       String size=JOptionPane.showInputDialog("Enter Size");
       return new Refrigirator(comp[0],comp[1],Double.parseDouble(comp[2]), Integer.parseInt(comp[3]),Refrigirator.class.getSimpleName(),
       company, size);
        
    }

    private Product getTV() {
        String basics= getBasics();
        String[] comp=basics.split(",");
       
        String company=JOptionPane.showInputDialog("Enter Company");
        String size=JOptionPane.showInputDialog("Enter Size");
       return new TV(comp[0],comp[1],Double.parseDouble(comp[2]), Integer.parseInt(comp[3]),TV.class.getSimpleName(),
       company, size);
    }
}
