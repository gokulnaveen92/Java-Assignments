// You are using Java
//validating Email Address custom Exception
 import java.util.*;
import java.util.regex.*;

class DotException extends Exception{
    public DotException(String msg){
        super(msg);
    }
}

class AtTheRateException extends Exception{
    public AtTheRateException(String msg){
        super(msg);
    }
}

class DomainException extends Exception{
    public DomainException(String msg){
        super(msg);
    }
}

class Main{
    
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        try{
            int count1=0;
            int count2=0;
            int count3=0;
            String email = sc.nextLine();
            String sCrt = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.(in|com|net|biz)$";
            Pattern p1 = Pattern.compile(sCrt);
            Matcher m1 = p1.matcher(email);
            String[] dom = {"in","com","net","biz"};

           
            
            for(int i=0;i<email.length();i++){
                if(email.charAt(i)=='@'){
                    count1++;
                }
                if(email.charAt(i)=='.'){
                    count2++;
                }
            }
            
            if(count2!=0){
            String[] emailcheck = email.split("\\.");
            //System.out.println(Arrays.toString(emailcheck));
            for(String d : dom){
                if(emailcheck[1].equals(d)){
                    count3++;
                }
            }
            }
            if(count2!=1){
                throw new DotException("Invalid Dot usage \nInvalid email address");
            }
            else if(count1!=1){
                throw new AtTheRateException("Invalid @ usage \nInvalid email address");
            }else if(count3!=1){
                throw new DomainException("Invalid Domain \nInvalid email address");
            }else{
                System.out.println("Valid email address");
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
