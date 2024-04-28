// You are using Java
//Handling book invalid quantity
import java.util.*;
class Book {
    String id,bookTitle,authorname;
    int quantity;
    float price;
    
    Book(String id,String bookTitle,String authorname,float price,int quantity){
        this.id = id;
        this.bookTitle = bookTitle;
        this.authorname = authorname;
        this.price = price;
        this.quantity = quantity;
    }
    
    public void purchase(int qcheck) throws InvalidQuantityException{
        if(qcheck>quantity){
            throw new InvalidQuantityException("Quantity not available");
        }else{
            quantity -= qcheck;
            System.out.println("Quantity available : "+quantity);
        } 
    }
}

class InvalidQuantityException extends Exception{
    InvalidQuantityException(String error){
        super(error);
    }

}

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String id = sc.nextLine();
        String bookTitle = sc.nextLine();
        String authorname = sc.nextLine();
        float price = sc.nextFloat();
        sc.nextLine();
        int quantity = sc.nextInt();
        sc.nextLine();
        int qcheck = sc.nextInt();
        
        Book B = new Book(id,bookTitle,authorname,price,quantity);
        try{
            B.purchase(qcheck);
        }catch(InvalidQuantityException e){
            System.out.println(e);
        }
        
    }
}
