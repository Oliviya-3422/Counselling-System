import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {
    private String name;
    private String roll_no;
    private int Total;
    private float cuttoff;

    public Student(String roll_no, String name, int total, float cuttoff) {
        this.roll_no = roll_no;
        this.name = name;
        this.Total = total;
        this.cuttoff = cuttoff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public float getCuttoff() {
        return cuttoff;
    }

    public void setCuttoff(float cuttoff) {
        this.cuttoff = cuttoff;
    }
}

public class portal {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        // Map<String,Student> students=new HashMap<>();

        view_portal view = new view_portal();

        students.add(new Student("001", "Jency", 563, 98.1f));
        students.add(new Student("002", "Suresh", 587, 95.4f));
        students.add(new Student("003", "Bala", 547, 90.4f));
        students.add(new Student("004", "Snekha", 589, 91.4f));
        students.add(new Student("005", "Shree", 555, 89.4f));
        int choice;
        do {
            System.out.println("\t1.Add Students in the portal\n\t2.Add College in the Portal\n\t3.Select College\n\t4.Show Students Selected College\n\t5.EXIT\nPlease enter your choice:");
            choice = in.nextInt(); // Input
            switch (choice) {
                case 1:
                    add_student add = new add_student();
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
                    System.out.println("Sorry your enter the wrong choice..");
                    System.exit(0);

            }
        }while(choice != 5);
    }
}

class add_student {
    static Scanner in = new Scanner(System.in);
    String roll_no;
    String name;
    int total;
    float cuttoff;



    void add(ArrayList<Student> students) {
        // ArrayList<Student> adds= new ArrayList<>();
        System.out.println("Please enter student Roll no:");
        roll_no = in.next();
        System.out.println("Please Enter student name:");
        name = in.next();

        System.out.println("if you know your total and cuttoff(Y/N):");
        System.out.println("Enter your choice");
        String choice = in.next().toUpperCase();
        // System.out.println(choice);

        if (choice.equals("Y")) {
            System.out.println("Please Enter your Total");
            total = in.nextInt();

            System.out.println("Please Enter your Cut off");
            cuttoff = in.nextFloat();

            students.add(new Student(roll_no, name, total, cuttoff));
            System.out.println("Successfully added to the portal");
            System.out.println("If you want to see the list of college by you assigned(Y/N):");
            String choice1 = in.next().toUpperCase();

            if (choice1.equals("Y")) {
                view_portal view = new view_portal();
                view.view(students);

            } else {
                System.out.println("Add one more student (Y/N):");
                System.out.println("Enter your choice");
                String addNew = in.next().toUpperCase();

                if (addNew.equalsIgnoreCase("Y")) {
                    add(students);

                } else {
                    System.out.println("Thank you for using the portal.... :)");
                    System.exit(0);
                }

            }

            // for (Student student : students) {
            // System.out.println("Name: " + student.getName());
            // System.out.println("Age: " + student.getTotal());
            // System.out.println("Course: " + student.getCuttoff());
            // System.out.println();
            // }

        } else {
            System.out.println("Please Enter your language Mark:");
            int language = in.nextInt();
            System.out.println("Please Enter your english:");
            int eng = in.nextInt();
            System.out.println("please Enter your maths:");
            int math = in.nextInt();
            System.out.println("please enter your subject-1:");
            int sub_1 = in.nextInt();
            System.out.println("please enter your subject-2");
            int sub_2 = in.nextInt();
            System.out.println("please enter your subject-3");
            int sub_3 = in.nextInt();
            total = language + eng + math + sub_1 + sub_2 + sub_3;

            float maths = math / 2;
            float chem = sub_1 / 4;
            float phy = sub_2 / 4;

            cuttoff = maths + chem + phy;
            students.add(new Student(roll_no, name, total, cuttoff));
            System.out.println("Successfully added");
            System.out.println("If you want to see the list of college by you assigned(Y/N):");
            String choice1 = in.next().toUpperCase();
            if (choice1.equals("Y")) {
                view_portal view = new view_portal();
                view.view_normal(students);
                // view_portal view =new view_portal();
                // view.view(students);

            } else {
                System.out.println("Add one more student (Y/N):");
                System.out.println("Enter your choice");
                String addNew = in.next().toUpperCase();

                if (addNew.equalsIgnoreCase("Y")) {
                    add(students);

                } else {
                    System.out.println("Thank you for using the portal.... :)");
                    System.exit(0);
                }
                // System.out.println("Thank you for using the portal.... :)");
                // System.exit(0);
            }

            // students.put(String.valueOf(adds.getRoll_no()),new Student(adds.getName(),
            // adds.getTotal(), adds.getCuttoff()));

        }

    }
}



class view_portal {
    static Scanner in = new Scanner(System.in);

    static HashMap<String,Integer> college = new HashMap<>();
    static HashMap<String,String> finalised = new HashMap<>();

    public void choosed(){

        int no=1;
        for (Map.Entry<String, String> fin : finalised.entrySet()) {

            String roll = fin.getKey();
            String[] det = fin.getValue().split("-");
            String name = det[0];
            String dept = det[1];


            System.out.printf("%-10s %-20s %-20s %-20s\n","Serial Number","Roll Number","College Name","Department");
            System.out.printf("%-10s %-20s %-20s %-20s\n",no,roll,name,dept);
            no++;

        }

    }

    public void available_college(){

        int i=1;

        while(i!=0){
            System.out.println("Enter the College Name : ");
            String name = in.nextLine();
            System.out.println("Enter the Department1 : ");
            String dept1 = in.nextLine();
            System.out.println("Enter the Department2 : ");
            String dept2 = in.nextLine();
            System.out.println("Enter the Department3 : ");
            String dept3 = in.nextLine();
            System.out.println("College and Department Added Successfully !!");

            System.out.println("Continue to add more collage ?");
            System.out.println("Enter 1 to Add \nEnter 2 to Exit");
            String ch = in.nextLine();
            if(ch.equals("2")){
                i = 0;
            }
        }

    }
    public void select(ArrayList<Student> students){

        HashMap<Integer,String> selected = new HashMap<>();

        Collections.sort(students, Comparator.comparing(Student::getCuttoff).reversed());

        System.out.println("Enter Your Roll Number : ");
        String roll = in.next();
        int t =0;

        for(Student student : students) {
            t++;
            if (roll.equals(student.getRoll_no())){
                t--;
                break;
            }
        }

        System.out.println(college.size()+" "+t);

        int no = 1;
        for (Map.Entry<String, Integer> get : college.entrySet()) {

            String college_det = get.getKey();
            String[] det = college_det.split("-");  
            String name = det[0];
            String dept = det[1];
            int available_Seats = get.getValue();
            System.out.printf("%-10s %-20s %-20s %-20s\n","Serial Number","College Name","Department","Available Seats");
            System.out.printf("%-10s %-20s %-20s %-20s\n",no,name,dept,available_Seats);
            selected.put(no,college_det);
            no++;
        }

        boolean lo = true;
        while (lo!=false) {

            System.out.println("Enter The Serial Number of the Collage you want to choose : ");
            int num = in.nextInt();

            String col = selected.get(num);
            int avail = college.get(col);
            if (avail == 0) {
                System.out.println("Sorry All Seats were booked please select a different college !!");
            }
            else{
                college.replace(col,avail-1);
                finalised.put(roll,col);
                System.out.println("College Selected Successfully!!!!");
                lo = false;
            }
        }
    }

    void view(ArrayList<Student> students){
    
        System.out.println("Please Enter your Roll no:");
        String Roll = in.next();
    
        System.out.println("Enter the College(1.Rathinam,2.PSG,3.Karpagam:)");
        int College=in.nextInt();
        System.out.println("Enter the Branch(1.CSE,2.IT,3.Mech:)");
        int Branch=in.nextInt();
        System.out.println("College:"+College);
        System.out.println("Branch:"+Branch);
        System.out.println(" roll number:");
        int rollNumber=in.nextInt();
        System.out.println(rollNumber);

        switch (Branch){
            case 1:
                System.out.println("Branch Allocated is CSE");
                break;
            case 2:
                System.out.println("Branch Allocated is IT");
                break;
            case 3:
                System.out.println("Branch Allocated is Mech");
                break;
            default:
                System.out.println("--\"Your Entered branch is not registered in the portal\"--");
                System.exit(0);
        }

        switch (College){
            case 1:
                System.out.println("College Allocated is Rathinam");
                break;
            case 2:
                System.out.println("College Allocated is PSG");
                break;
            case 3:
                System.out.println("College Allocated is Karpagam");
                break;
            default:
            System.out.println("--\"Your Entered college is not registered in the portal\"--");
            System.exit(0);

        }
      
        System.out.println("|------------------------------------------------------|");

    }

    void view_normal(ArrayList<Student> students) {
        // des
        Collections.sort(students, Comparator.comparing(Student::getCuttoff).reversed());
        for (Student student : students) {

            System.out.println();
            System.out.println("|-----------------------------------------------|");
            System.out.println("             Roll_no: " + student.getRoll_no());
            System.out.println("|-----------------------------------------------|");
            System.out.println("             Name: " + student.getName());
            System.out.println("|-----------------------------------------------|");
            System.out.println("             Total: " + student.getTotal());
            System.out.println("|-----------------------------------------------|");
            System.out.println("             Cutt_off: " + student.getCuttoff());
            System.out.println("|-----------------------------------------------|");
            System.out.println();
            System.out.println();
        }

    }
}