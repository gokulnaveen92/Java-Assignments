// You are using Java
//Hotel Reservation
import java.util.*;
import java.sql.*;
class Main{
    void display(Connection con,PreparedStatement pst,ResultSet rs){
        try{
        pst = con.prepareStatement("SELECT*FROM room");
        rs = pst.executeQuery();
        while(rs.next()){
            System.out.println("room_number: "+rs.getInt("room_number")+", room_type: "+rs.getString("room_type")+", capacity: "+rs.getInt("capacity")+", availability: "+rs.getString("availability")+", price: "+rs.getInt("price"));
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        
        Main m = new Main();
        
        try{
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ri_db","test","test123");
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        switch(n){
            case 1:
                //System.out.println("going in case 1");
                int rno = Integer.parseInt(sc.nextLine());
                //System.out.println(rno);
                String rtype = sc.nextLine();
                //System.out.println(rtype);
                int capacity = Integer.parseInt(sc.nextLine());
                //System.out.println(capacity);
                String availability = sc.nextLine();
                //System.out.println(availability);
                int price = Integer.parseInt(sc.nextLine());
                //System.out.println(price);
                pst = con.prepareStatement("insert into room(room_number,room_type,capacity,availability,price) values(?,?,?,?,?)");
                pst.setInt(1,rno);
                pst.setString(2,rtype);
                pst.setInt(3,capacity);
                pst.setString(4,availability);
                pst.setInt(5,price);
                int x = pst.executeUpdate();
                //System.out.println(x);
                if(x>0){
                System.out.println("room record inserted successfully.");
                m.display(con,pst,rs);
                }
                break;
                
        
            case 2:
                int rno1 = Integer.parseInt(sc.nextLine());
                //System.out.println(rno);
                String rtype1 = sc.nextLine();
                //System.out.println(rtype);
                int capacity1 = Integer.parseInt(sc.nextLine());
                //System.out.println(capacity);
                String availability1 = sc.nextLine();
                //System.out.println(availability);
                int price1 = Integer.parseInt(sc.nextLine());
                //System.out.println(price);
                pst = con.prepareStatement("UPDATE room SET room_type = ?,capacity = ?,availability = ?,price = ? where room_number=?");
                pst.setString(1,rtype1);
                pst.setInt(2,capacity1);
                pst.setString(3,availability1);
                pst.setInt(4,price1);
                pst.setInt(5,rno1);
                pst.executeUpdate();
                System.out.println("room record updated successfully.");
                m.display(con,pst,rs);
                break;
            case 3:
                int rn3 = Integer.parseInt(sc.nextLine());
                pst = con.prepareStatement("DELETE FROM room where room_number=?");
                pst.setInt(1,rn3);
                pst.executeUpdate();
                System.out.println("room record deleted successfully.");
                m.display(con,pst,rs);
                break;
            case 4:
                m.display(con,pst,rs);
            case 5:
                int rno3 = Integer.parseInt(sc.nextLine());
                pst = con.prepareStatement("SELECT * FROM room where room_number=?");
                pst.setInt(1,rno3);
                rs = pst.executeQuery();
                System.out.println("Room Details");
                while(rs.next()){
                    System.out.println("room_number: "+rs.getInt("room_number"));
                    System.out.println("room_type: "+rs.getString("room_type"));
                    System.out.println("capacity: "+rs.getInt("capacity"));
                    System.out.println("availability: "+rs.getString("availability"));
                    System.out.println("price: "+rs.getInt("price"));
                }
                break;
        }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
    }
}
