import java.sql.*;

class Main {
    
     Connection con= null;
     PreparedStatement ps= null;
     ResultSet rs= null;
     
    void connect(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/ri_db","test","test123");
        System.out.println("Connected...");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    void addData(){
        try{
            ps = con.prepareStatement("insert into emp values(?,?)");
            ps.setInt(1,10);
            ps.setString(2,"Loki");
            ps.executeUpdate();
            System.out.println("Added...");
        } catch(Exception e){
            System.out.println("Failed Added");
        }
    }
    
    void searchData(){
        try{
            ps=con.prepareStatement("select *from emp");
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Id: "+rs.getInt(1)+" Name: "+rs.getString(2));
            }
        }catch(Exception e){
            System.out.println("Error in getting...");
        }
    }
    
    void deleteData(){
        try{
            ps = con.prepareStatement("delete from emp where eid=?");
            ps.setInt(1,10);
            ps.executeUpdate();
            System.out.println("Deleted...");
        } catch(Exception e){
            System.out.println("Error in deletion");
        } finally {
            try{
            con.close();
            System.out.println("Connection closed Successfully");
            }catch(Exception e){}
      }
    }
    
    void searchEmpById(){
        try{
            ps = con.prepareStatement("select *from emp where eid=?");
            ps.setInt(1,10);
            rs = ps.executeQuery();
            if(rs.next())
            System.out.println("Searched Employeee: ID: "+rs.getInt(1)+" Name: " + rs.getString(2));
            else
            System.out.println("No records found");
        }catch(Exception e){
            System.out.println("Error in Searching");
        }
    }
    
    void updateEmp(){
        try{
            ps = con.prepareStatement("update emp set name=? where eid=?");
            ps.setString(1,"Tin");
            ps.setInt(2,10);
            ps.executeUpdate();
            System.out.println("Updated...");
        }catch(Exception e){
            System.out.println("Error in Updated");
        }
    }
    
    void searchEmpdetails(){
        try{
            ps = con.prepareStatement("select name,salary from emp where eid = ?");
            ps.setInt(1,10);
            rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("Name: "+rs.getString(1)+"salary: "+rs.getInt(2));
            }
        }catch(Exception e){
            System.out.println("error in fetching the details..");
        }
    }
    public static void main(String args[]){
        Main m = new Main();
        m.connect();
        m.addData();
        m.searchData();
        m.searchEmpById();
        m.updateEmp();
        m.deleteData();
        
    }
}
