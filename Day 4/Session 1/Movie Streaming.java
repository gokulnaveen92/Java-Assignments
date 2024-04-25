// You are using Java
import java.util.*;
class Movie{
    private String title;
    private int releaseYear;
    private double rating;
    
    Movie(String title,int releaseYear,double rating){
        this.title=title;
        this.releaseYear=releaseYear;
        this.rating=rating;
    }
    
    public double getRating(){
        return this.rating;
    }
    
    
    @Override
    public String toString(){
        return "Title: "+this.title+", Release Year: "+this.releaseYear+", Rating: "+this.rating;
    }
    
}

class MovieComparator implements Comparator<Movie>{
    
    @Override
    public int compare(Movie m1,Movie m2){
        return Double.compare(m1.getRating(),m2.getRating());
    }
    
    
}
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Movie> arrList = new ArrayList<>();
        Movie m;
        
        for(int i=0;i<n;i++){
          String name = sc.nextLine();
          int releaseYear = Integer.parseInt(sc.nextLine());
          double rating = Double.parseDouble(sc.nextLine());
          m = new Movie(name,releaseYear,rating);
          arrList.add(m);
        }
        
        Collections.sort(arrList,new MovieComparator());
        
        for(Movie m1 : arrList){
            System.out.println(m1.toString());
        }
    }
}
