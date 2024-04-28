// You are using Java
//Employee display

// You are using Java
//Student database 
import java.util.*;
import java.sql.*;
class Main{
    public static void main(String[] args){
        try{
        
       
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ri_db","test","test123");
        System.out.println("Database connected successfully.");
        PreparedStatement pst = null;
        ResultSet rs = null;
        

        String sql = "SELECT name as n FROM employee WHERE name LIKE '%s' OR name LIKE '%n' ";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("n"));
        }
            
        }catch(Exception e){
            System.out.println(e);
        }finally{
           System.out.println("Connection closed successfully.");
        }
        
    }
}
