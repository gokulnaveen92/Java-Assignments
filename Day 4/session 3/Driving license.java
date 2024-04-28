// You are using Java
//HAndling driving licensse
import java.util.*;

class InvalidAgeForDrivingLicenseException extends Exception{
    public InvalidAgeForDrivingLicenseException(String msg){
        super(msg);
    }
}

class InvalidMarkForDrivingLicenseException extends Exception{
    public InvalidMarkForDrivingLicenseException(String msg){
        super(msg);
    }
}


class Main{
    String name;
    int userAge,mark;
    
    Main(String name,int userAge,int mark){
        this.name = name;
        this.userAge = userAge;
        this.mark = mark;
    }
    
    
    public void elgigble(int age,int marks) throws InvalidAgeForDrivingLicenseException,InvalidMarkForDrivingLicenseException{
            if(age<18){
                throw new InvalidAgeForDrivingLicenseException("Age should be more than 18 years old");
            }else{
                if(mark<80){
                    throw new InvalidMarkForDrivingLicenseException("Mark should be more than 80");
                }
                else{
                    System.out.println("Approved");
                }
            }
       
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String name = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());
        int marks = Integer.parseInt(sc.nextLine());
        
        Main m = new Main(name,age,marks);
        
        try{
            if(age>0){
                if(marks<100 && marks>0){
                m.elgigble(age,marks);
                }else{
                    throw new InvalidMarkForDrivingLicenseException("Invalid mark");
                }
            }else{
                throw new InvalidAgeForDrivingLicenseException("Invalid age");
            }
        }catch(InvalidAgeForDrivingLicenseException e){
            System.out.println(e);
        }catch(InvalidMarkForDrivingLicenseException ie){
            System.out.println(ie);
        }
    }

}
