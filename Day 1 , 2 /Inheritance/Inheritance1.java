// You are using Java
import java.util.*;
class Person{
    String firstName,lastName;
    
    Person(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
}

class Employee extends Person {
    int employeeid;
    String jobTitle;
    
    Employee(String firstName,String lastName,int employeeid,String jobTitle){
        super(firstName,lastName);
        this.employeeid = employeeid;
        this.jobTitle = jobTitle;
    }
    
    void display(){
        System.out.println("Employee details:");
        System.out.println("Name:" + firstName + " " + lastName +", "+jobTitle);
        System.out.println("Employee ID: " + employeeid );
    }
}

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String firstName = sc.nextLine();
        String lastName = sc.nextLine();
        int employeeid = sc.nextInt();
        sc.nextLine();
        String jobTitle = sc.nextLine();
        
        Employee e = new Employee(firstName,lastName,employeeid,jobTitle);
        e.display();
    }
}
