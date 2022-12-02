
package employee.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateEmp extends JFrame implements  ActionListener {
    

    
    JTextField tfeducation,tffname,tfsalary,tfphn,tfadres,tfmail,tfadhr,tfdesg;
    JButton add,back;
    JLabel lblempid;
    String empid;
    
    public UpdateEmp(String empId){
        this.empid = empId;
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel hdg = new JLabel("Update Employee Details");
        hdg.setBounds(300,30,500,50);
        hdg.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        hdg.setForeground(new Color(0,153,153));
        add(hdg);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
        //father name
        JLabel labelfname = new JLabel(" Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        //dob
        
        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);
        
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
        //salary
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        
        JLabel labeladres = new JLabel("Address");
        labeladres.setBounds(50,250,150,30);
        labeladres.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladres);
        
        tfadres = new JTextField();
        tfadres.setBounds(200,250,150,50);
        add(tfadres);
        
        //phone
        
        JLabel labelphn = new JLabel("Phone");
        labelphn.setBounds(400,250,150,30);
        labelphn.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphn);
        
        tfphn = new JTextField();
        tfphn.setBounds(600,250,150,30);
        add(tfphn);
        
        //mail
        JLabel labelmail = new JLabel("Email");
        labelmail.setBounds(50,350,150,30);
        labelmail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelmail);
        
        tfmail = new JTextField();
        tfmail.setBounds(200,350,150,30);
        add(tfmail);
        
        //eductaion
        
          
        JLabel labeledu = new JLabel("Highest Education");
        labeledu.setBounds(400,350,150,30);
        labeledu.setFont(new Font("serif",Font.PLAIN,20));
        add(labeledu);
        
        
     
        tfeducation = new JTextField();
        tfeducation.setBackground(Color.white);
        tfeducation.setBounds(600,350,150,30);
        add(tfeducation);
        
        //designation
        
        JLabel labeladesg = new JLabel("Designation");
        labeladesg.setBounds(50,400,150,30);
        labeladesg.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladesg);
        
        tfdesg = new JTextField();
        tfdesg.setBounds(200,400,150,30);
        add(tfdesg);
        
        //adhaar
        
        JLabel labeladhr = new JLabel("Adhaar No.");
        labeladhr.setBounds(400,400,150,30);
        labeladhr.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladhr);
        
        JLabel lbladhar = new JLabel();
        lbladhar.setBounds(600,400,150,30);
        add(lbladhar);
        
        //employeeid
        JLabel labelempid = new JLabel("Employee ID.");
        labelempid.setBounds(50,450,150,30);
        labelempid.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempid);
        
        lblempid = new JLabel();
        lblempid.setBounds(200,450,150,30);
        lblempid.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempid);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs  = c.st.executeQuery(query);
            
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                tfadres.setText(rs.getString("address"));
                tfphn.setText(rs.getString("phone"));
                tfmail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                tfdesg.setText(rs.getString("designation"));
                lbladhar.setText(rs.getString("adhaar"));
                lblempid.setText(rs.getString("empId"));
                
            
            }
        }catch(Exception e){
            e.printStackTrace();
        
        }
        
        //button
        
        add = new JButton("Update Details");
        add.setBounds(250,550,150,40);
        add.setBackground(new Color(153,153,255));
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450,550,150,40);
        back.setBackground(new Color(153,153,255));
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        setSize(900,650);
        setLocation(250,30);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== add){

            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfadres.getText();
            String phone = tfphn.getText();
            String email = tfmail.getText();
            String education = (String)tfeducation.getText();
            String designation = tfdesg.getText();
       
            
            
            
            try{
                Conn con = new Conn();
                String query = "update  employee set fname = '"+fname+"', salary = '"+salary+"',"
                        + " address = '"+address+"', phone = '"+phone+"', email = '"+email+"'"
                        + ",education = '"+education+"',designation = '"+designation+"' where empId = '"+empid+"'";
                con.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully!!");
                setVisible(false);
                new Home();
                
            }catch(Exception e){
                e.printStackTrace();
            
            }
        
        }
        else{
            setVisible(false);
            new Home();
        
        }
    
    }
    
    public static void main(String[]args){
        new UpdateEmp("");
    
    }
    
}
