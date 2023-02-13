import java.util.*;

class Student{
    private String name;
    private String roll_no;
    private int Total;
    private float cuttoff;

    public Student(String roll_no,String name, int total, float cuttoff) { 
        this.roll_no=roll_no;
        this.name=name;
        this.Total=total;
        this.cuttoff=cuttoff;
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

public class Main {
static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
      ArrayList<Student> students =new ArrayList<>();


        students.add(new Student("001","Jency",563,98.1f));
        students.add(new Student("002","Suresh",587, 95.4f));
        students.add(new Student("003","Bala;",547, 90.4f));
        System.out.println("    1.Add Students to the portal\n    2.View Poral List Students\n\nPlease enter your choice:");
        int choice=in.nextInt();
        switch (choice){
            case 1:
                add_student add=new add_student();
                add.add(students);
                break;

            case 2:
                view_portal view =new view_portal();
                view.view_normal(students);
                break;

            default:
                System.out.println("Sorry your entered the wrong choice..");
                System.exit(0);

        }
    }
}

class add_student{
    static Scanner in=new Scanner(System.in);
 String roll_no;
   String name;
    int total;
    float cuttoff;


    void add(ArrayList<Student> students){
//        ArrayList<Student> adds= new ArrayList<>();
        System.out.println("Please enter your Roll no:");
        roll_no= in.next();
        System.out.println("Please Enter your name:");
        name=in.next();


        System.out.println("Do you know your total and cuttoff(Y/N):");
        System.out.println("Enter your choice");
        String choice= in.next().toUpperCase();
//        System.out.println(choice);

        if (choice.equals("Y")){
            System.out.println("Please Enter your Total");
            total=in.nextInt();

            System.out.println("Please Enter your Cut off");
            cuttoff =in.nextFloat();

            students.add(new Student(roll_no,name, total,cuttoff));
            System.out.println("Successfully added to the portal");
            System.out.println("If you want to see the College assigned for you(Y/N):");
            String choice1=in.next().toUpperCase();

            if(choice1.equals("Y")){
                view_portal view =new view_portal();
                view.view(students);

            }
            else{
                System.out.println("Thank you for using.... :)");
                System.exit(0);
            }

//            for (Student student : students) {
//                System.out.println("Name: " + student.getName());
//                System.out.println("Age: " + student.getTotal());
//                System.out.println("Course: " + student.getCuttoff());
//                System.out.println();
//            }


        }
        else{
             System.out.println("Please Enter your language Mark:");
             int language= in.nextInt();;
            System.out.println("Please Enter your english:");
            int eng= in.nextInt();
            System.out.println("please Enter your maths:");
            int math= in.nextInt();
            System.out.println("please enter your subject-1:");
            int sub_1=in.nextInt();
            System.out.println("please enter your subject-2");
            int sub_2=in.nextInt();
            System.out.println("please enter your subject-3");
            int sub_3=in.nextInt();
            total = language+eng+math+sub_1+sub_2+sub_3;

            float maths=math/2;
            float chem=sub_1/4;
            float phy=sub_2/4;
           

            cuttoff=maths+chem+phy;
            students.add(new Student(roll_no,name, total,cuttoff));
            System.out.println("Successfully added");
            System.out.println("If you want to see the list of college assigned for you(Y/N):");
            String choice1=in.next().toUpperCase();
            if(choice1.equals("Y")){
                view_portal view =new view_portal();
                view.view(students);

            }
            else{
                System.out.println("Thank you for using.... :)");
                System.exit(0);
            }

//            students.put(String.valueOf(adds.getRoll_no()),new Student(adds.getName(), adds.getTotal(), adds.getCuttoff()));

        }




    }
}
class view_portal{
    static Scanner in=new Scanner(System.in);
    void view(ArrayList<Student> students){
        int f=0;
        System.out.println("Please Enter your Roll no:");
        String roll=in.next();

        for (Student student : students) {

            if(roll.equals(student.getRoll_no())){
                f=1;
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("|------------------------------------------------------|");
                System.out.println(" Hi, " + student.getName());
                System.out.println("      Your Roll_no: " + student.getRoll_no());
                System.out.println("      Your Total: " + student.getTotal());
                System.out.println("      Your Cutt_off: " + student.getCuttoff());
                System.out.println();

                if(student.getCuttoff()>=90){
                    System.out.println("     -----Your assigned Clg is:   \"Anna University\"-----");
                    System.out.println();
                    break;
                }
                else if (student.getCuttoff()>=80 && student.getCuttoff()<90) {
                    System.out.println("---Your assigned Clg is:   \"Rathinam Technical Campus\"---");
                    System.out.println();
                    break;

                }
                else{
                    System.out.println("     -----Your assigned Clg is:   \"PSG College\"-----");
                    System.out.println();
                    break;

                }
            }

        }
         if(f==0){
            System.out.println("--\"Your Entered roll no is not registered in the portal\"--");
            System.exit(0);
        }
        System.out.println("|------------------------------------------------------|");

    }

    void view_normal(ArrayList<Student> students){
        for (Student student : students) {
            System.out.println();
            System.out.println("|-----------------------------------------------|");
            System.out.println("             Roll_no: " + student.getRoll_no());
            System.out.println("|-----------------------------------------------|");
            System.out.println("             Name: " + student.getName());
            System.out.println("|-----------------------------------------------|");
            System.out.println("             Total: " + student.getTotal());
            System.out.println("|-----------------------------------------------|");
            System.out.println("             Cut_off: " + student.getCuttoff());
            System.out.println("|-----------------------------------------------|");
            System.out.println();
            System.out.println();
        }

    }
}