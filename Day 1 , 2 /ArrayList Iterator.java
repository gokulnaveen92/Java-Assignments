// You are using Java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        ArrayList<Integer> arrList = new ArrayList<>();
        
        int temp = sc.nextInt();
        arrList.add(temp);
        //ListIterator<Integer> it = arrList.listIterator();
        for(int i=1;i<n;i++){
            int ele = sc.nextInt();
            ListIterator<Integer> it = arrList.listIterator();
            while(it.hasNext()){
                temp = it.next();
            }
            if(ele>temp){
                arrList.add(ele);
            }
        }
        System.out.println(arrList);
    }
}
