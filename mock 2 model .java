1)// You are using Java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        
        for(int i=0;i<n;i++){
            String[] input = sc.nextLine().split(",");
            String model = input[0].trim();
            int price = Integer.parseInt(input[1]);
            map.put(model,price);
        }
        
        String search = sc.nextLine();
        if(map.containsKey(search)){
            System.out.println(search + ": "+map.get(search));
        }else{
            System.out.println("is not there");
        }
        
        map.forEach((k,v) -> System.out.println(k+" "+v));
        
    }
}
2)// You are using Java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        LinkedHashSet<String> set = new LinkedHashSet<>();
        
        for(int i=0;i<n;i++){
           String model = sc.nextLine();
           set.add(model);
        }
        
        String tosearch = sc.nextLine();
        
        if(set.contains(tosearch)){
            System.out.println("is there");
        }else{
            System.out.println("is not there");
        }
        
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
3)// You are using Java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            String model = sc.nextLine();
            list.add(model);
        }
        
        String tosearch = sc.nextLine();
        
        if(list.contains(tosearch)){
            System.out.println("is there");
        }else{
            System.out.println("is not there");
        }
        
        for(String s : list){
            System.out.println(s);
        }
        
    }
}
4) // JDBC
// You are using Java
import java.util.*;
import java.sql.*;
class Main{
    void display(PreparedStatement pst,Connection con,ResultSet rs){
        try{
        pst = con.prepareStatement("SELECT * FROM lapdetails");
        rs = pst.executeQuery();
        while(rs.next()){
            System.out.print(rs.getInt("id")+" "+rs.getString("model")+" "+rs.getString("brand")+" "+rs.getInt("price")+" "+rs.getBoolean("allocated"));
            System.out.println();
        }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        Main m = new Main();
        try{
        Scanner sc = new Scanner(System.in);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ri_db","test","test123");
        System.out.println("Connected sucessfully");
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        
        int n = Integer.parseInt(sc.nextLine());
        
        switch(n){
            case 1:
                int id = Integer.parseInt(sc.nextLine());
                String model = sc.nextLine();
                String brand = sc.nextLine();
                int price = Integer.parseInt(sc.nextLine());
                boolean allocated = sc.nextBoolean();
                
                pst = con.prepareStatement("INSERT INTO lapdetails(id,model,brand,price,allocated) VALUES(?,?,?,?,?)");
                pst.setInt(1,id);
                pst.setString(2,model);
                pst.setString(3,brand);
                pst.setInt(4,price);
                pst.setBoolean(5,allocated);
                int x = pst.executeUpdate();
                if(x>0){
                    System.out.println("added");
                }
                
                m.display(pst,con,rs);
                break;
            
            case 2:
                m.display(pst,con,rs);
                break;
                
            case 3:
                int id2= Integer.parseInt(sc.nextLine());
                //System.out.println(id2);
                boolean allocated1 = sc.nextBoolean();
                //System.out.println(allocated1);
                sc.nextLine();
                int price1 = Integer.parseInt(sc.nextLine());
                //System.out.println(price1);
                pst = con.prepareStatement("UPDATE lapdetails SET allocated = ?,price = ? WHERE id = ?");
                pst.setInt(3,id2);
                pst.setBoolean(1,allocated1);
                pst.setInt(2,price1);
                int y = pst.executeUpdate();
                if(y>0){
                    System.out.println("updated sucessfully");
                }
                m.display(pst,con,rs);
                break;
                
            case 4:
                int id3 = Integer.parseInt(sc.nextLine());
                pst = con.prepareStatement("DELETE FROM lapdetails WHERE id=?");
                pst.setInt(1,id3);
                int z =pst.executeUpdate();
                if(z>0){
                    System.out.println("Deleted sucessfully");
                }
                m.display(pst,con,rs);
                break;
        }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
5)// You are using Java
import java.util.*;
interface Shape{
    public double area();
}

class Rectangle implements Shape{
    double length;
    double width;
    
    Rectangle(double length,double width){
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double area(){
        return length*width;
    }
}

class Triangle implements Shape{
    double height;
    double base;
    
    Triangle(double height,double base){
        this.height = height;
        this.base = base;
    }
    
    @Override
    public double area(){
        return height*base*0.5;
    }
}
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        
        switch(n){
            case 1:
                double length = Double.parseDouble(sc.nextLine());
                double width = Double.parseDouble(sc.nextLine());
                Rectangle r = new Rectangle(length,width);
                System.out.println("Rectangle area: " + r.area());
                break;
                
            case 2:
                double height = Double.parseDouble(sc.nextLine());
                double base = Double.parseDouble(sc.nextLine());
                Triangle t = new Triangle(height,base);
                System.out.println("Triangle area: " + t.area());
                break;
                
        }
    }
}
6)// You are using Java
import java.util.*;
class InvalidateAgeException extends Exception{
    InvalidateAgeException(String msg){
        super(msg);
    }
}

class InvalidateAadharException extends Exception{
    InvalidateAadharException(String msg){
        super(msg);
    }
}


class Main{
    
    void validate(int age ,boolean aadhar) throws InvalidateAgeException , InvalidateAadharException{
    if(age>=18){
        System.out.println(aadhar);
        if(!aadhar){
            throw new InvalidateAadharException("u r not having an aadhar card");
        }else{
            System.out.println("user validated");
        }
    }else{
        throw new InvalidateAgeException("age is less than 18");
    }
}
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Main m = new Main();
        
        int age = Integer.parseInt(sc.nextLine());
        boolean aadhar = Boolean.parseBoolean(sc.nextLine());
        System.out.println(aadhar);
        
        try{
            m.validate(age,aadhar);
        }catch(InvalidateAgeException e){
            System.out.println(e);
        }catch(InvalidateAadharException e){
            System.out.println(e);
        }
            
    }
}

