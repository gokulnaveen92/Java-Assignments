// You are using Java
import java.util.*;
class Employee implements Comparable<Employee>{
    private String name;
    private double score;
    
    Employee(String name,double score){
        this.name = name;
        this.score = score;
    }
    
    @Override
    public int compareTo(Employee other){
        return  Double.compare(other.score,this.score);
    }
    
    @Override
    public String toString(){
        return this.name+" "+this.score;    }
    
}

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Employee> arrList = new ArrayList<>();
        Employee e;
            for(int i=0;i<n;i++){
                String[] input = sc.nextLine().split(" ");
                String name = input[0];
                    double score =Double.valueOf(input[1]);                      
                    e = new Employee(name,score);
                    arrList.add(e);
        }
        
        Collections.sort(arrList);
        
        for(Employee e1 : arrList){
            System.out.println(e1.toString());
        }
    }
}
