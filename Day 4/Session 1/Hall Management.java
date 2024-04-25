// You are using Java
import java.util.*;
class Hall implements Comparable<Hall>{
    private String name,contactNumber,ownerName;
    private double costPerDay;
    
    Hall(String name,String contactNumber,double costPerDay,String ownerName){
        this.name = name;
        this.contactNumber = contactNumber;
        this.ownerName = ownerName;
        this.costPerDay = costPerDay;
    }
    
    @Override
    public int compareTo(Hall other){
        return (int)(this.costPerDay - other.costPerDay);
    }
    
    @Override
    public String toString(){
        return this.name +" "+ this.contactNumber +" "+this.costPerDay+" "+this.ownerName;
    }
}
class Main{
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       
       int n = sc.nextInt();
       sc.nextLine();
       ArrayList<Hall> arrList = new ArrayList<>(); 
       Hall h;
       
       for(int i=0;i<n;i++){
           String name = sc.nextLine();
           String contactNumber = sc.nextLine();
           double costPerDay = sc.nextDouble();
           sc.nextLine();
           String ownerName = sc.nextLine();
           h = new Hall(name,contactNumber,costPerDay,ownerName);
           arrList.add(h);
       }
       
       Collections.sort(arrList);
       
       for(Hall h1 : arrList){
           System.out.println(h1.toString());
       }
       
    }
}
