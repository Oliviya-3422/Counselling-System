import java.util.ArrayList;
import java.util.Scanner;

class StudentDetails {
    static Scanner in = new Scanner(System.in);
    String rollNo;
    String name;
    int total;
    float cutOff;



    void add(ArrayList<Student> students) {
        // ArrayList<Student> adds= new ArrayList<>();
        System.out.println("Please enter student Roll no :");
        rollNo = in.next();
        System.out.println("Please Enter student name :");
        name = in.next();

        System.out.println("if you know your total and cuttoff(Y/N) :");
        System.out.println("Enter your choice");
        String choice = in.next().toUpperCase();
        // System.out.println(choice);

        if (choice.equals("Y")) {
            System.out.println("Please Enter your Total");
            total = in.nextInt();

            System.out.println("Please Enter your Cut off");
            cutOff = in.nextFloat();

            students.add(new Student(rollNo, name, total, cutOff));
            System.out.println("Successfully added");
            System.out.println("Do you want to see the college assigned for you(Y/N):");
            String choice1 = in.next().toUpperCase();

            if (choice1.equals("Y")) {
                AUCounselling view = new AUCounselling();
                view.view(students);

            } else {
                System.out.println("Add one more student (Y/N):");
                System.out.println("Enter your choice");
                String addNew = in.next().toUpperCase();

                if (addNew.equalsIgnoreCase("Y")) {
                    add(students);

                } 

            }

            // for (Student student : students) {
            // System.out.println("Name: " + student.getName());
            // System.out.println("Age: " + student.getTotal());
            // System.out.println("Course: " + student.getCuttoff());
            // System.out.println();
            // }

        } else {
            System.out.println("Please Enter your language Mark :");
            int language = in.nextInt();
            System.out.println("Please Enter your english :");
            int eng = in.nextInt();
            System.out.println("please Enter your maths :");
            int Maths = in.nextInt();
            System.out.println("please enter your Chemistry :");
            int Chemistry = in.nextInt();
            System.out.println("please enter your Physics :");
            int Physics = in.nextInt();
            System.out.println("please enter your subject-3 :");
            int sub3 = in.nextInt();
            total = language + eng + Maths + Chemistry + Physics + sub3;

            float math = Maths / 2;
            float chem = Chemistry / 4;
            float phy = Physics / 4;

            cutOff = math + chem + phy;
            students.add(new Student(rollNo, name, total, cutOff));
            System.out.println("Successfully added");
            System.out.println("If you want to see the cutoff marks of the students (Y/N) :");
            String choice1 = in.next().toUpperCase();
            if (choice1.equals("Y")) {
                AUCounselling view = new AUCounselling();
                view.view_normal(students);
                // view_portal view =new view_portal();
                // view.view(students);

            } else {
                System.out.println("Add one more student (Y/N) :");
                System.out.println("Enter your choice");
                String addNew = in.next().toUpperCase();

                if (addNew.equalsIgnoreCase("Y")) {
                    add(students);

                }
                // System.out.println("Thank you for using the portal.... :)");
                // System.exit(0);
            }

            // students.put(String.valueOf(adds.getRoll_no()),new Student(adds.getName(),
            // adds.getTotal(), adds.getCuttoff()));

        }

    }



    public void available_college() {
    }



    public void select(ArrayList<Student> students) {
    }



    public void choosed() {
    }
}
