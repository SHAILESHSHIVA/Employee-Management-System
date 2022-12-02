
package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OpeningPage extends JFrame implements ActionListener {
    
     JButton click; 
    
    OpeningPage(){
        
        setLayout(null);
        getContentPane().setBackground(new Color(204,204,255));
      
        
        JLabel hdg = new JLabel("Employee Management System");
        hdg.setForeground(new Color(0,153,153));
        hdg.setBounds(200,30,1200,60);
        hdg.setFont(new Font("Serif",Font.PLAIN,50));
        add(hdg);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pics/op3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,130,1000,500);
        add(image);
        
        click  = new JButton("Click Here To Continue");
        click.setBounds(350,430,300,65);
        click.setBackground(new Color(0,51,102));
        click.setForeground(Color.white);
        click.setFont(new Font("Serif",Font.PLAIN,20));
        click.addActionListener(this);
        image.add(click);
        
        
        setSize(1100,700);
        setLocation(150,30);
        setVisible(true);
        
            
        while(true){
            hdg.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
            }
            
            hdg.setVisible(true);
              try{
                Thread.sleep(700);
            }catch(Exception e){
            }
        }
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    
     }
    
    
    public static void main(String[]args){
        
        new OpeningPage();
    
    }
    
}
