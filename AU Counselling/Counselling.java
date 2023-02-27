import java.util.ArrayList;
import java.util.Scanner;

public class Counselling {
   
         
    static Scanner in = new Scanner(System.in);
    

    public static void main(String[] args) {
        Student classObject=new Student(null, null, 0, 0);
        classObject.printStudent();
        ArrayList<Student>students = new ArrayList<>();
        //Map<String,Student> students=new HashMap<>();

        CollegeDetails view = new CollegeDetails();

        students.add(new Student("001", "Jency", 563, 98.1f));
        students.add(new Student("002", "Suresh", 587, 95.4f));
        students.add(new Student("003", "Bala", 547, 90.4f));

        int choice;
        do {
            System.out.println("\t1.Add Students \n\t2.Add College \n\t3.Select College\n\t4.Show Student's Selected College\n\t5.EXIT\nPlease enter your choice:");
            choice = in.nextInt(); // Input
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
                    break;

               default:
                System.out.println("Enter a valid choice:");
                for(int i=1 ;i<=5;i++)
                {
                    
                   }
                

            }
        }while(choice != 5);
    }
}
