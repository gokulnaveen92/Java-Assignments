// You are using Java
//EMPLPOYEE DETAILS
import java.util.*;
import java.sql.*;
class Main{
    void display(PreparedStatement pst,Connection con,ResultSet rs){
        try{
            pst = con.prepareStatement("select * from office where ESALARY between 10000 and 50000");
            rs = pst.executeQuery();
            while(rs.next()){
                System.out.print(rs.getInt("EID")+" "+rs.getString("ENAME")+" "+rs.getInt("ESALARY"));
                System.out.println();
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args){
        Main m = new Main();
        
        try{
            Scanner sc = new Scanner(System.in);
            
            int n = Integer.parseInt(sc.nextLine());
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ri_db","test","test123");
            System.out.println("Database connected successfully.");
            PreparedStatement pst = null;
            ResultSet rs = null;
            
            for(int i=0;i<n;i++){
            int eid = Integer.parseInt(sc.nextLine()); 
            String name = sc.nextLine();
            int salary = Integer.parseInt(sc.nextLine());
            pst = con.prepareStatement("INSERT INTO office(EID,ENAME,ESALARY) values(?,?,?)");
            pst.setInt(1,eid);
            pst.setString(2,name);
            pst.setInt(3,salary);
            pst.executeUpdate();
            }
            m.display(pst,con,rs);
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            System.out.println("Connection closed successfully.");
        }
    }
}
