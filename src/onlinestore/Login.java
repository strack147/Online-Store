/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

import Model.Database;
import Model.UserPass;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author tp3976,tp4248,tp4280,tp4304
 */
public class Login extends JFrame implements ActionListener{
    private JTextField username;
    private JPasswordField password;
    private JButton login;
    public UserPass userPass;
    private JButton exit;
    private Database data;
    Login(UserPass userPass, Database data){
        super("Login");
        this.data=data;
        setLayout(new GridBagLayout());
        this.userPass=userPass;
        username=new JTextField(10);
        password=new JPasswordField(10);
        login=new JButton("Login");
        
        GridBagConstraints gc=new GridBagConstraints();
        
        
        //first row
        gc.gridx=0;
        
        gc.gridy=0;
        
        gc.insets=new Insets(10,5,0,0);
        add(new JLabel("Enter Username:"),gc);
        gc.gridx++;
        add(username,gc);
        //second row
        gc.gridx=0;
        gc.gridy++;
        
        add(new JLabel("Enter Password:"),gc);
        gc.gridx++;
        add(password,gc);
        
        
        gc.insets=new Insets(10,0,0,-120);
        gc.gridx=0;
        gc.gridy++;
        exit=new JButton("Cancel");
        add(login, gc);
        
        //second row
        gc.gridx=1;
        gc.insets=new Insets(10,45,0,0);
        add(exit,gc);
        
        
        
        setSize(250,250);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        login.addActionListener(this);
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(userPass.getList().size()==0){
            if(username.getText().equals(userPass.USERNAME)){
                if(new String(password.getPassword()).equals(userPass.PASSWORD)){
                    setVisible(false);
                    this.username.setText("");
                    this.password.setText("");
                    Administrator admin=new Administrator(this, this.data);
                    
                }
                else{
                    JOptionPane.showMessageDialog(Login.this, "Password Incorrect","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
             else{
                    JOptionPane.showMessageDialog(Login.this, "Username Incorrect","Error", JOptionPane.ERROR_MESSAGE);
                }
        }
        else{
          Model.Entity user=this.userPass.getUser(username.getText(), new String(password.getPassword()));
          if(user!=null){
              if(user.getType()==Model.Type.ADMINISTRATOR)
                  new Administrator(this, data);
              else
                  new User(this, data);
          }
          else{
              JOptionPane.showMessageDialog(this, "No User Found");
          }
        }
    }
    
}
