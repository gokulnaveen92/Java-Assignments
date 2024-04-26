// You are using Java
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        
        
        List<Integer> arrList = new ArrayList<>();
        
        for(int num : arr){
            if(map.get(num)==1){
                arrList.add(num);
            }
        }
         
        //System.out.println(arrList);
        
        int[] arr1 = new int[arrList.size()];
        
        for(int i=0;i<arrList.size();i++){
            arr1[i]=arrList.get(i);
        }
        
        int len = arr1.length;
        //System.out.println(Arrays.toString(arr1));
        if(arrList.isEmpty()){
            System.out.println("0");
        }else{
            System.out.println(SumUniqueElements(arr1,len));
        }
    }
    static int SumUniqueElements(int[] arr , int n){
        int sum = 0;
        for(int x : arr){
            sum = sum+x;
        }
        return sum;
    }
}
