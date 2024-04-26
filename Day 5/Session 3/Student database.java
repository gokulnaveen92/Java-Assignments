// You are using Java
//Student database 
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
        
        int n = Integer.parseInt(sc.nextLine());
        int m = 0;
        for(int i=1;i<=n;i++){
            //System.out.println("im in for loop");
            int rollNo = Integer.parseInt(sc.nextLine());
            String name = sc.nextLine();
            int m1 = Integer.parseInt(sc.nextLine());
            int m2 = Integer.parseInt(sc.nextLine());
            int m3 = Integer.parseInt(sc.nextLine());
            pst = con.prepareStatement("insert into student(rollno,sname,mark1,mark2,mark3) values(?,?,?,?,?)");
            pst.setInt(1,rollNo);
            pst.setString(2,name);
            pst.setInt(3,m1);
            pst.setInt(4,m2);
            pst.setInt(5,m3);
            m = pst.executeUpdate();
            m++;
            //System.out.println(m);
            }
            System.out.println(m);
        }catch(Exception e){
            System.out.println(e);
        }finally{
           System.out.println("Connection closed successfully.");
        }
        
    }
}
