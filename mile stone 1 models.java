1)// You are using Java
import java.util.*;
class Student{
    private float m1,m2,m3;
    private int sid;
    private String name;
    double total;
    
    Student(int sid,String name,float m1,float m2,float m3){
        this.sid = sid;
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;

    }
    
    public double getTotalMarks(){
        total = this.m1 + this.m2 + this.m3;
        return total;
    }
    
    public double getPercentage(){
        return (total/3);
    }
    
}

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int sid = Integer.parseInt(sc.nextLine());
        String name = sc.nextLine();
        float m1 = Float.parseFloat(sc.nextLine());
        float m2 = Float.parseFloat(sc.nextLine());
        float m3 = Float.parseFloat(sc.nextLine());
        
        Student s = new Student(sid,name,m1,m2,m3);
        System.out.println(s.getTotalMarks());
        System.out.println(s.getPercentage());
        
        
    }
}
2)// You are using Java
import java.util.*;

class InvalidAgeException extends Exception{
    InvalidAgeException(String msg){
        super(msg);
    }
}

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int age = sc.nextInt();
        try{
            if(age>18 && age<=100){
                System.out.println("Valid for Vote");
            }else if(age<+0){
                throw new InvalidAgeException("age must be greater than 0");
            }else if(age>100){
                throw new InvalidAgeException("age should not be greater than 100");
            }
            else{
                throw new InvalidAgeException("InValid to vote");
            }
        }catch(InvalidAgeException e){
            System.out.println(e);
        }
        
    }
}
3)// You are using Java
import java.util.*;
import java.sql.*;

class Main{
    void display(PreparedStatement pst,Connection con,ResultSet rs){
        try{
        pst = con.prepareStatement("SELECT * FROM mobile ");
        rs = pst.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt("sno")+" "+rs.getString("model")+" "+rs.getString("brand")+" "+rs.getInt("price"));
        }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        Main m = new Main();
        try{
           Scanner sc = new Scanner(System.in);
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ri_db","test","test123");
           PreparedStatement pst = null;
           ResultSet rs = null;
           
           int n = Integer.parseInt(sc.nextLine());
           
           switch(n){
               case 1:
                   int sno = sc.nextInt();
                   sc.nextLine();
                   String mod = sc.nextLine();
                   String brand = sc.nextLine();
                   int price = sc.nextInt();
                   pst = con.prepareStatement("INSERT INTO mobile(sno,model,brand,price) VALUES(?,?,?,?)");
                   pst.setInt(1,sno);
                   pst.setString(2,mod);
                   pst.setString(3,brand);
                   pst.setInt(4,price);
                   int x = pst.executeUpdate();
                   if(x>0){
                       System.out.println("inserted");
                   }
                   m.display(pst,con,rs);
                   break;
                 
                case 2:
                    m.display(pst,con,rs);
                    
                case 3:
                    int id = sc.nextInt();
                    sc.nextLine();
                    String name1 = sc.nextLine();
                    int price1 = sc.nextInt();
                    pst = con.prepareStatement("UPDATE mobile SET model=?,price=? WHERE sno=?");
                    pst.setInt(3,id);
                    pst.setString(1,name1);
                    pst.setInt(2,price1);
                    int y = pst.executeUpdate();
                    if(y>0){
                        System.out.println("Updates sucessfully");
                    }
                    m.display(pst,con,rs);
                    break;
                    
                case 4:
                    int id1 = sc.nextInt();
                    pst = con.prepareStatement("DELETE FROM mobile WHERE sno=?");
                    pst.setInt(1,id1);
                    int z = pst.executeUpdate();
                    if(z>0){
                        System.out.println("Upadted successfully");
                    }
                    m.display(pst,con,rs);
                   
           }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
