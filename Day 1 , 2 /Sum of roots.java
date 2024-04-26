// You are using Java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] arr1 = new int[n];
        
        for(int i=0;i<n;i++){
            arr1[i] = sc.nextInt();
        }
        
        List<Integer> arrList = new ArrayList<>();
        int sum =0;
        
        for(int num : arr1){
            double root = Math.sqrt(num);
            //System.out.println(root);
            if(root%1==0){
                sum = sum+(int) root;
                //System.out.println("current sum :" + sum);
            }
        }
        
        System.out.println(sum);
    }
}
