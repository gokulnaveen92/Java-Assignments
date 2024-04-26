// You are using Java
//Handing IllegalArgumentException and ArithmeticException
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
       try{
           int num = sc.nextInt();
           if(num!=0){
               try{
                   if(num<7){
                       System.out.println(num);
                   }else{
                       throw new IllegalArgumentException();
                   }
               }catch(IllegalArgumentException ie){
                   System.out.println("IllegalArgumentException caught - Number should not be greater than 7");
               }
            }else{
               throw new ArithmeticException();
            }
        }
        catch(ArithmeticException e){
            System.out.println("ArithmeticException caught - / by zero");
        }
    } 
}
