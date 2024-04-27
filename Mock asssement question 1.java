import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            String[] input = sc.nextLine().split(" ");
            String player = input[0];
            int runs = Integer.parseInt(input[1]);
            
            map.put(player,runs);
            
        }
        
        String PLayerName = sc.nextLine();
        if(map.containsKey(PLayerName)){
            System.out.println(PLayerName + " " + map.get(PLayerName));
            System.out.println("Total number of players: " + map.size());
        }
        
        map.forEach((k,v) -> System.out.println(k+" "+v));
    }
}
