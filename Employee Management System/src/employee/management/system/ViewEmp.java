
package employee.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class ViewEmp extends JFrame implements ActionListener{
    
    JTable table;
    Choice cemployeeid;
    JButton search,print,update,back;
    public ViewEmp(){
        
        getContentPane().setBackground(new Color(153,153,255));
        setLayout(null);
        
        JLabel srch = new JLabel("Search by Employee Id");
        srch.setBounds(20,20,150,20);
        srch.setForeground(Color.white);
        add(srch);
        
        cemployeeid = new Choice();
        cemployeeid.setBounds(180,20,150,20);
        add(cemployeeid);
        
            
        try{
            Conn c = new Conn();
            ResultSet rs = c.st.executeQuery("select * from employee");
//            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            while(rs.next()){
                cemployeeid.add(rs.getString("empId"));
            
            }
        }
        catch(Exception e){
            e.printStackTrace();
        
        }
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.st.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            while(rs.next()){
                cemployeeid.add(rs.getString("empId"));
            
            }
        }
        catch(Exception e){
            e.printStackTrace();
        
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        search.setBackground(new Color(0,76,153));
        search.setForeground(Color.white);
        add(search);
        
        print = new JButton("print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        print.setBackground(new Color(0,76,153));
        print.setForeground(Color.white);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        update.setBackground(new Color(0,76,153));
        update.setForeground(Color.white);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        back.setBackground(new Color(0,76,153));
        back.setForeground(Color.white);
        add(back);
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==search){
            String query = "select * from employee where empId = '"+cemployeeid.getSelectedItem()+"'";
            
            try{
                Conn con  = new Conn();
                ResultSet rs = con.st.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            
            }
        }else if(ae.getSource()==print){
            try{
                table.print();
            }catch (Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmp(cemployeeid.getSelectedItem());
        }
        else{
            setVisible(false);
            new Home();
        }
    
    }
    
    public static void main(String[]args){
    
        new ViewEmp();
    }
    
}
