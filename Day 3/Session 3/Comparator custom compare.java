
// You are using Java
import java.util.*;
import java.lang.*;
import java.io.*;
class Student{
    int rollno,rank;
    String name,address;
    
    Student(int rollno,String name,String address,int rank){
        this.rollno = rollno;
        this.name = name;
        this.address = address;
        this.rank = rank;
    }
    
    public String toString(){
        return String.valueOf(this.rollno) + " " + this.name + " " + this.address + " " + this.rank;
    }
}
class Sortbyname implements Comparator<Student>{
    
    @Override
    public int compare(Student s1,Student s2){
        return s1.name.compareTo(s2.name);
    }
}

class Sortbyroll implements Comparator<Student>{
    @Override
    public int compare(Student s1,Student s2){
        return s1.rollno-s2.rollno;
    }
}

class SortbyRank implements Comparator<Student>{
    boolean asc ;
    
    SortbyRank(boolean asc){
        this.asc = asc;
    }
    
    
    @Override
    public int compare(Student s1,Student s2){
        if(asc){
            return s1.rank - s2.rank;
        }else{
            return s2.rank - s1.rank;
        }
    }
}

// Write your code here, create classes

class Main
{
	public static void main (String[] args)
	{
		ArrayList<Student> ar = new ArrayList<Student>();
		
		Scanner s = new Scanner(System.in);
		
		String Welcome = "Student Interactive Console : \n1) Add User\n2) Sort Student List by Roll no\n3) Sort Student List by Name"
		                + "\n4) sort Students by Rank\n5) Exit from System\n";
		int choice = 0;
		
		do {
		    
		    System.out.println(Welcome);
		    System.out.println("Enter your choice : ");
		    choice = s.nextInt();
		    
		    
		    switch(choice) {
		        case 1 : 
		            s.nextLine();
		            System.out.println("Enter the rollno, name, address and rank (separated by comma) ");
		            String[] temp = s.nextLine().split(",");
		            Student stu = new Student(Integer.parseInt(temp[0]), temp[1], temp[2], Integer.parseInt(temp[3]));
		            ar.add(stu);
		            break;
		        case 2 : 
		            s.nextLine();
		            Collections.sort(ar, new Sortbyroll());
		            System.out.println("\nStudents List sorted by rollno");
		            for (int i=0; i<ar.size(); i++)
		            	System.out.println(ar.get(i).toString());
		            break;
		        case 3:
		            s.nextLine();
		            Collections.sort(ar, new Sortbyname());
		            System.out.println("\nStudents List sorted by rollno");
		            for (int i=0; i<ar.size(); i++)
		            	System.out.println(ar.get(i).toString());
		            break;
		        case 4:
		            s.nextLine();
		            System.out.println("Sort by ascending or descending ( asc / des) ");
		            boolean asc = s.nextLine().equalsIgnoreCase("asc") ? true : false;
		            
		            Collections.sort(ar, new SortbyRank(asc));
		            System.out.println("\nStudents List sorted by Rank");
		            for (int i=0; i<ar.size(); i++)
		            	System.out.println(ar.get(i).toString());
		            break;
		        case 5 : 
		            System.out.println("Exiting ....");
		            System.exit(0);
		        default :
		            s.nextLine();
		            System.out.println("\nInvalid Input Try again !!!\n");
		            
		    }
		    
		} while (choice != 5 );

    }
}
