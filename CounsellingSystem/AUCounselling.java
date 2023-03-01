import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class AUCounselling {
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
            System.out.println("Enter the Department : ");
            String dept = in.nextLine();
           
           
        
            college.put(name+"-"+dept,2);
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

        Collections.sort(students, Comparator.comparing(Student::getCutOff).reversed());

        System.out.println("Enter Your Roll Number : ");
        String roll = in.next();
        int t =0;

        for(Student student : students) {
            t++;
            if (roll.equals(student.getRollNo())){
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

        boolean b1 = true;
        while (b1!=false) {

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
                b1 = false;
            }
        }
    }

   /*  void view(ArrayList<Student> students){
    
        System.out.println("Please Enter your Roll no:");

        in.nextInt();
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

   
    }*/
    void view_normal(ArrayList<Student> students) {
       
        Collections.sort(students, Comparator.comparing(Student::getCutOff).reversed());
        
        for (Student student : students) {

            System.out.println();
            System.out.println("|-----------------------------------------------|");
            System.out.println("             Roll_no: " + student.getRollNo());
            System.out.println("|-----------------------------------------------|");
            System.out.println("             Name: " + student.getName());
            System.out.println("|-----------------------------------------------|");
            System.out.println("             Total: " + student.getTotal());
            System.out.println("|-----------------------------------------------|");
            System.out.println("             Cutt_off: " + student.getCutOff());
            System.out.println("|-----------------------------------------------|");
            System.out.println();
            System.out.println();
        }

    }

    public void view(ArrayList<Student> students) {
    }
}