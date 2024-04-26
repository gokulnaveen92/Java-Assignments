// You are using Java
import java.util.*;
class Transaction{
    int transactionId;
    double amount;
    
    Transaction(int transactionId,double amount){
        this.transactionId = transactionId;
        this.amount = amount;
    }
    
    void getTransactionInfo(){
        
    }
}

class PeerToPeerTransaction extends Transaction{
    String recipient;
    
    PeerToPeerTransaction( int transactionId ,double amount,String recipient){
        super(transactionId,amount);
        this.recipient = recipient;
    }
    
    void getTransactionInfo(){
        System.out.println("Peer-to-peer Transaction:");
        System.out.println("Transaction ID: "+ transactionId);
        System.out.println("Amount: $" + amount );
        System.out.println("Recipient: " + recipient);
    }
}

class OnlinePurchaseTransaction extends Transaction{
    String merchant;
    
    OnlinePurchaseTransaction(int transactionId,double amount,String merchant){
        super(transactionId,amount);
        this.merchant = merchant;
    }
    
    void getTransactionInfo(){
       System.out.println("Online purchase Transaction:");
       System.out.println("Transaction ID: " + transactionId);
       System.out.println("Amount: $" + amount);
       System.out.println("Merchant: " + merchant);
    }
}

class BillPaymentTransaction extends Transaction{
    String billType;
    
    BillPaymentTransaction(int transactionId,double amount,String billType){
        super(transactionId,amount);
        this.billType = billType;
    }
    
    void getTransactionInfo(){
        System.out.println("Bill Payment Transaction:");
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Amount: $" + amount);
        System.out.println("Bill Type: " + billType);
    }
}
 class Main{
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String recipient,merchant,billType;
        int transactionId;
        double amount;
        
        transactionId = sc.nextInt();
        amount = sc.nextDouble();
        sc.nextLine();
        recipient = sc.nextLine(); 
        merchant = sc.nextLine();
        billType = sc.nextLine();
        
        PeerToPeerTransaction p = new PeerToPeerTransaction(transactionId,amount,recipient);
        p.getTransactionInfo();
        System.out.println();
        
        OnlinePurchaseTransaction online = new OnlinePurchaseTransaction(transactionId,amount,merchant);
        online.getTransactionInfo();
        System.out.println();
        
        BillPaymentTransaction B = new BillPaymentTransaction(transactionId,amount,billType);
        B.getTransactionInfo();
        System.out.println();
        
     }
 }
