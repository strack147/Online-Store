/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

import Model.Database;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author tp3976, tp4248 , tp4280, tp4304
 */
public class ShowAllUsersGui extends JFrame{
    public ShowAllUsersGui()
    {
        super("Presentation Clientele");
        this.setSize(500, 200);
        this.setVisible(true);
        this.setLayout(new GridBagLayout());
        this.setLocationRelativeTo(null);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;
        c.weightx=1;
        c.weighty=1;
        ArrayList<String> users = new ArrayList<String>();
        Database db = new Database();
        users=db.getAllUserstoShow();
        int i =0;
        
        
        for(i=0;i<users.size();i++)
        {
            c.gridy++;
            JLabel usernamelabel = new JLabel(users.get(i));
            this.add(usernamelabel,c);
            c.gridy++;
            
        }
    }
}
