
 //You are using Java
import java.util.*;
class sortBylength implements Comparator<String>{
    @Override
    public int compare(String s1,String s2){
        return s1.length()-s2.length();
    }
}
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> arrList = new ArrayList<>();
        
        for(int i = 0;i<n;i++){
            String str = sc.nextLine();
            arrList.add(str);
        }
        
        Collections.sort(arrList,new sortBylength());
        System.out.println(arrList);
    }
}
