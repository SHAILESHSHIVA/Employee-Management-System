
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    
    JButton add, view,update,remove;
    
    public Home(){
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pics/hmm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel hdg = new JLabel("Employee Management System");
        hdg.setBounds(650,30,400,40);
        hdg.setFont(new Font("Raleway",Font.BOLD,25));
        hdg.setForeground(new Color(102,0,204));
        image.add(hdg);
        
        add = new JButton("Add Employee");
        add.setBounds(650,80,150,40);
        add.setBackground(new Color(153,153,255));
        add.setForeground(Color.white);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("View Employees");
        view.setBounds(820,80,150,40);
        view.setBackground(new Color(153,153,255));
        view.setForeground(Color.white);
        view.addActionListener(this);
        image.add(view);
    
        
        update = new JButton("Update Employee");
        update.setBounds(650,150,150,40);
        update.setBackground(new Color(153,153,255));
        update.setForeground(Color.white);
        update.addActionListener(this);
        image.add(update);
        
            
        remove = new JButton("Remove Employee");
        remove.setBounds(820,150,150,40);
        remove.setBackground(new Color(153,153,255));
        remove.setForeground(Color.white);
        remove.addActionListener(this);
        image.add(remove);
        
        setSize(1120,630);
        setLocation(150,50);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == add){
            //add buttonevent
            setVisible(false);
            new AddEmployee();
        
        }else if(ae.getSource() == view){
            //view button event
            setVisible(false);
            new ViewEmp();
            
        
        }else if(ae.getSource() == update){
            //updat button event
            setVisible(false);
            new ViewEmp();
        
        }
        else{
            //remove button event
            setVisible(false);
            new RemoveEmp();
        
        }
        
    
    }
    
    public static void main(String[] args){
        
        new Home();
        
    
    }
    
}
