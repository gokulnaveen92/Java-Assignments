
// You are using Java
//Student id and name where dept = given 
import java.util.*;
import java.sql.*;
class Main{
    public static void main(String[] args){
        try{
        
        Scanner sc = new Scanner(System.in);
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ri_db","test","test123");
        System.out.println("Database connected successfully.");
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        String deptname = sc.nextLine();
        String sql = "SELECT id ,name FROM student WHERE department=?";
        pst = con.prepareStatement(sql);
        pst.setString(1,deptname);
        rs = pst.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt("id")+" "+rs.getString("name"));
        }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
           System.out.println("Connection closed successfully.");
        }
        
    }
}

