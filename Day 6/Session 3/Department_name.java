// You are using Java
//department_name
import java.util.*;
import java.sql.*;

class Main{

    
    public static void main(String[] args){
        Main m = new Main();
        
        try{
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ri_db","test","test123");
            System.out.println("Database connected successfully.");
            PreparedStatement pst = null;
            ResultSet rs = null;
            
            

            pst = con.prepareStatement("SELECT * FROM department WHERE department_name LIKE 'J%'");
            rs = pst.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("department_id")+" "+rs.getString("department_name"));
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            System.out.println("Connection closed successfully.");
        }
    }
    
}
