
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    
    JTextField passtxt;
    JTextField usertxt;
       
    Login(){
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel user = new JLabel("Username");
        user.setBounds(40,40,100,30);
        add(user);
        
        usertxt = new JTextField();
        usertxt.setBounds(160,40,180,30);
        add(usertxt);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(40,90,100,30);
        add(pass);
        
        passtxt = new JPasswordField();
        passtxt.setBounds(160,90,180,30);
        add(passtxt);
        
        JButton login  = new JButton("LOGIN");
        login.setBounds(160,150,180,50);
        login.setBackground(new Color(0,51,102));
        login.setForeground(Color.white);
//        login.setFont(new Font("Serif",Font.PLAIN,20));
        login.addActionListener(this);
        add(login);
//        image.add(click);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pics/log.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,0,100,200);
        add(image);


        
        
        
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        try{
           String username = usertxt.getText();
           String password = passtxt.getText();
           
           Conn con = new Conn();
           
           String query  = "select * from login where username = '"+username+"' and password = '"+password+"' ";
           
           ResultSet rs = con.st.executeQuery(query);
           
           if(rs.next()){
               setVisible(false);
               new Home();
//               JOptionPane.showMessageDialog(null, "Make next window plss ");
//               setVisible(false);

           }
           else{
               JOptionPane.showMessageDialog(null, "Invalid username or password");
               setVisible(false);
               new Login();
           }
          
        }
        catch(Exception e){
            e.printStackTrace();
        }
    } 
    
    
    public static void main(String[] args){
        
        new Login();
    }
    
}
