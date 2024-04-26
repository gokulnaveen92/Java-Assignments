// You are using Java
//Input Mismatch Exception
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        try{
            int n = sc.nextInt();
            System.out.println(n);
        }catch(InputMismatchException ie){
            System.out.println(ie);
        }
    }
}
