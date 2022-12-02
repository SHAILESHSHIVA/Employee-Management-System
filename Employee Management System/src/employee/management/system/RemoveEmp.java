
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class RemoveEmp extends JFrame implements ActionListener {
    
    Choice cempid;
    JButton delete,back;
    
    
    public RemoveEmp(){
        
       getContentPane().setBackground(Color.white);
       setLayout(null);
       
       JLabel labelempid = new JLabel("Employee Id");
       labelempid.setBounds(50,50,100,30);
       add(labelempid);
       
       cempid = new Choice();
       cempid.setBounds(200,50,150,30);
       add(cempid);
       
       try{
           Conn c = new Conn();
           String query = "select * from employee";
           ResultSet rs = c.st.executeQuery(query);
           
           while(rs.next()){
               cempid.add(rs.getString("empId"));
           
           }
       }catch(Exception e){
           e.printStackTrace();
       }
       
       JLabel lblname = new JLabel("Name");
       lblname.setBounds(50,100,100,30);
       add(lblname);
       
       JLabel lbelname = new JLabel();
       lbelname.setBounds(200,100,100,30);
       add(lbelname);
       
       
       JLabel lblphone = new JLabel("Phone");
       lblphone.setBounds(50,150,100,30);
       add(lblphone);
       
       JLabel lbelphone = new JLabel();
       lbelphone.setBounds(200,150,100,30);
       add(lbelphone);
       
       
       JLabel lblmail = new JLabel("Email");
       lblmail.setBounds(50,200,100,30);
       add(lblmail);
       
       JLabel lbelmail = new JLabel();
       lbelmail.setBounds(200,200,100,30);
       add(lbelmail);
       
        try{
           Conn c = new Conn();
           String query = "select * from employee where empId = '"+cempid.getSelectedItem()+"'";
           ResultSet rs = c.st.executeQuery(query);
           
           while(rs.next()){
               lbelname.setText(rs.getString("name"));
               lbelphone.setText(rs.getString("phone"));
               lbelmail.setText(rs.getString("email"));
               
               
           
           }
       }catch(Exception e){
           e.printStackTrace();
       }
        
       cempid.addItemListener(new ItemListener() {
           
           public void itemStateChanged(ItemEvent ie){
             try{
                  Conn c = new Conn();
                  String query = "select * from employee where empId = '"+cempid.getSelectedItem()+"'";
                  ResultSet rs = c.st.executeQuery(query);

                  while(rs.next()){
                      lbelname.setText(rs.getString("name"));
                      lbelphone.setText(rs.getString("phone"));
                      lbelmail.setText(rs.getString("email"));



                  }
              }catch(Exception e){
                  e.printStackTrace();
              }
          }
       
   });
       
        
       delete = new JButton("Delete");
       delete.setBounds(80,300,100,30);
       delete.setBackground(new Color(0,76,153));
       delete.setForeground(Color.white);
       delete.addActionListener(this);
       add(delete);
       
       back = new JButton("Back");
       back.setBounds(220,300,100,30);
       back.setBackground(new Color(0,76,153));
       back.setForeground(Color.white);
       back.addActionListener(this);
       add(back);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pics/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,600,350);
        add(image);
        
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== delete){
            
            try{
                Conn c = new Conn();
                String query = "delete from employee where empId = '"+cempid.getSelectedItem()+"'";
                c.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted!!");
                setVisible(false);
                new Home();
            }catch(Exception e){
               e.printStackTrace();
            }
        
        }else{
            setVisible(false);
            new Home();
        
        }
        
    
    }
    
    public static void main(String[] args){
        
        new RemoveEmp();
    
    }
    
}
