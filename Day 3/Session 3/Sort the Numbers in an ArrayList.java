
// You are using Java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> arrList = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            int ele = sc.nextInt();
            arrList.add(ele);
        }
        
        Collections.sort(arrList);
        
        int toSearch = sc.nextInt();
        boolean isthere = arrList.contains(toSearch);
        
        if(isthere){
            System.out.println("Found at position: "+(arrList.indexOf(toSearch)+1));
            System.out.println(arrList);
        }else{
            for(int i=0;i<n;i++){
                if(arrList.get(i)>toSearch){
                    //System.out.println(arrList.get(i));
                    arrList.add((i),toSearch);
                    System.out.println("Not found, added at position: "+(i+1));
                    break;
                }else{
                    if(arrList.get(n-1)<toSearch){
                        arrList.add(toSearch);
                        System.out.println("Not found, added at position: "+ (n+1));
                        break;
                        
                    }
                    
                }
            }
            System.out.println(arrList);
        }
        
        
    }
}
