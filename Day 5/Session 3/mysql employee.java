// You are using Java
//mysql employee
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
            
            pst = con.prepareStatement("select*from employee");
            rs = pst.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getDouble("salary"));
            }
            rs.close();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }finally{
            System.out.println("Connection closed successfully.");
        }
    }
}
