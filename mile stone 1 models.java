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
