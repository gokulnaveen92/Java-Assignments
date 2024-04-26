// You are using Java
import java.util.*;
interface Game{
    void playGame();
    void playGame(String playerName);
    void playGame(String playerName,int level);
}

class Test implements Game{
    
    @Override
    public void playGame(){
        System.out.println("Playing the game without any parameters.");
    }
    
    @Override
    public void playGame(String playerName){
        System.out.println("Playing the game with player name: " + playerName);
    }
    
    @Override
    public void playGame(String playerName,int level){
        System.out.println("Playing the game with player name: " + playerName + " and level: " + level);
    }
)
class Main{
    public void static main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        Test t = new Test();
        int n = Sc.nextInt();
        sc.nextLine();
        
        if(n==1){
            t.playGame();
        }else if(n==2){
            String playerName = sc.nextLine();
            t.playGame(playerName);
        }else if(n==3){
            String playerName = sc.nextLine();
            int level = sc.nextInt();
            t.playGame(playerName,level);
        }
    }
}
