import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Counselling {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        // Map<String,Student> students=new HashMap<>();

        AUCounselling view = new AUCounselling();

        students.add(new Student("001", "Jency", 563, 98.1f));
        students.add(new Student("002", "Suresh", 587, 95.4f));
        students.add(new Student("003", "Bala", 547, 90.4f));
        students.add(new Student("004","Snekha",590,97.2f));
        students.add(new Student("005","Shree Hari",596,97.1f));

        int choice;
        do {
            System.out.println("\t1.Add Students \n\t2.Add College \n\t3.Select College\n\t4.Show Students Selected College\n\t5.EXIT\nPlease enter your choice :");
            choice = 0;
            try {
                choice = in.nextInt(); // Input
            } catch (Exception e) {
                // TODO: handle exception
               
                System.out.println("pls be aware of the input provided");
                
                for(int i=0; i<=5; i++);
                
                
            }
            switch (choice) {
                case 1:
                    StudentDetails add = new StudentDetails();
                    add.add(students);
                    break;

                case 2:
                    view.available_college();
                    break;
                case 3:
                    view.select(students);
                break;
                case 4:
                    view.choosed();
                    break;

                case 5:
                    System.out.println("Thank you");
                    System.exit( 0);

                
                default:
                    System.out.println("Enter a valid choice:");
                 
            }
        }while(choice != 5);
    }
}