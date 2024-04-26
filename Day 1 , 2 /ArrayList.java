// You are using Java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> arrList = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            arrList.add(num);
        }
        
        int searchelement = sc.nextInt();
        int elemToRemove = sc.nextInt();
        
        boolean isthere = arrList.contains(searchelement);
        
        if(isthere){
            System.out.println("Number "+searchelement+" exists in the ArrayList");
        }
        else{
            System.out.println("Number "+searchelement+" not exists in the ArrayList");
        }
        
        arrList.remove(Integer.valueOf(elemToRemove));
        
        System.out.println("ArrayList after removing "+elemToRemove);
        for(int y : arrList){
            System.out.print(y+" ");
        }
        System.out.println();
        
        System.out.println("ArrayList elements using normal for loop");
        for(int i=0;i<arrList.size();i++){
            System.out.print(arrList.get(i)+" ");
        }
        System.out.println();
        
        Iterator<Integer> it = arrList.iterator();
        System.out.println("ArrayList elements using Iterator interface");
        while(it.hasNext()){
           System.out.print(it.next()+" "); 
        }
        System.out.println();
        
        System.out.println("ArrayList elements using for-each loop");
        for(int x : arrList){
            System.out.print(x+" ");
        }
        System.out.println();
        
        Collections.sort(arrList,Collections.reverseOrder());
        System.out.println("ArrayList elements in descending order");
        for(int z : arrList){
            System.out.print(z+" ");
        }
        System.out.println();
        
        System.out.println("Number of elements in the ArrayList: "+arrList.size());
        

        
    }
}
