// You are using Java
//Employee salaries greater
import java.util.*;
import java.sql.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        
        try{
            double salaryToCompare = Double.parseDouble(sc.nextLine());
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ri_db","test","test123");
            System.out.println("Database connected successfully.");
            PreparedStatement pst = null;
            ResultSet rs = null;
            
            pst = con.prepareStatement("SELECT * FROM employee WHERE salary >= "+salaryToCompare );
            rs = pst.executeQuery();
            
            if(rs.next()){
                System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getDouble("salary"));
                while(rs.next()){
                    System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getDouble("salary"));
                }
            }else{
                System.out.println("No records found for the given salary threshold.");
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
