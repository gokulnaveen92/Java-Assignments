// You are using Java
import java.util.*;
import java.sql.*;
class Main{
    public static void main(String[] args){
        try{

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ri_db","test","test123");
            PreparedStatement pst = null;
            ResultSet rs = null;
            
            pst = con.prepareStatement("SELECT * FROM student WHERE physics <= 70 AND total < 200");
            rs = pst.executeQuery();
            while(rs.next()){
                System.out.print(rs.getInt("student_id")+" "+rs.getString("student_name")+" "+rs.getInt("maths")+" "+rs.getInt("physics")+" "+rs.getInt("chemistry")+" "+rs.getInt("total"));
                System.out.println();
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
