
package employee.management.system;

import java.sql.*;


public class Conn {
    
    Connection c;
    Statement st;
    public Conn(){
        
        try{
            //Register driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            //creating connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeesystem",
                    "root","admin");
            //creating statement class
            st = c.createStatement();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
}
