import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class Main
{
    static Scanner sc = new Scanner(System.in);
    static List<Student> studentList = new ArrayList<>();
    public static void main(String[] args) 
    {

        while (true) 
        {
            System.out.println("MENU: \n 1. Student Information \n 2. Add Student \n 3. Edit Information \n 4. Delete Student \n 5. Sort Student \n 6. Search Student \n 7. Exit");
            System.out.print("Enter option: ");
            int input = sc.nextInt();
            //information
            switch (input){
                case 1:
                viewInfor();
                break;

                case 2:
                addStudent();
                break;
                
                case 3:
                editStudent();
                break;

                case 4:
                delStudent();
                break;

                case 5:
                sortStudent();
                break;
                
                case 6:
                searchStudent();
                break;

                case 7:
                System.out.println("Loging out...");
                System.exit(0);
                default:
                System.out.println("Invalid choice! Please enter the number inside the menu.");
                break;
            }

        }
        
    }


    public static void viewInfor(){
        System.out.println("List of Student:");
        for(Student student : studentList){
            System.out.println("ID: "+student.getID());
            System.out.println("Name: "+student.getName());
            System.out.println("Class: "+student.getStudentClass());
            System.out.println("Marks: "+student.getMarks());
            student.rankedStudent();
            System.out.println("------");
        }
    }


    public static void addStudent()
    {
        System.out.print("------\nAdd Student \nEnter student's number: ");
        while (!sc.hasNextInt()){
            System.out.println("Invalid Input!\nPlease enter an integer for Student Number.");
            sc.next();
        }
        int studentNumber = sc.nextInt();
        if (studentNumber <= 0){
            System.out.println("Invalid Input!\nPlease enter an number greater than 0.");
        }
        sc.nextLine();
        for (int i = 0; i < studentNumber;i++)
        {
            System.out.println("Enter student ID: ");
            String studentID = sc.nextLine();
            if (isStudentIDDuplicate(studentID)){
                System.out.println("Id can not be duplicate! Please enter unique ID");
                i--;
                continue;
            }

            System.out.println("Enter student Name: ");
            String studentName = sc.nextLine();

            System.out.println("Enter student Class: ");
            String studentClass = sc.nextLine();

            double studentMarks;
            while(true){
                System.out.println("Enter student Mark:");
                if (sc.hasNextDouble()){
                    studentMarks = sc.nextDouble();

                    if (studentMarks >= 0 && studentMarks <= 10){
                        sc.nextLine();
                        break;
                        
                    }
                    else{
                        System.out.println("Invalid! Please enter a number that GREATER THAN 0 AND SMALLER THAN 10");
                        sc.nextLine();
                    }
                }
                else{
                    System.out.println("Please enter a number");
                    sc.nextLine();

                }

            }
            System.out.println("------");
            Student student = new Student(studentID, studentName, studentClass, studentMarks);
            studentList.add(student);            
        }
        
    }
    private static boolean isStudentIDDuplicate(String studentID){
        for (Student student : studentList){
            if (student.getID().equals(studentID)){
                return true;
                //found duplicate
            }
        }
        return false;
        //nothing duplicate
    }


    public static void editStudent()
    {
        viewInfor();
        sc.nextLine(); 
        System.out.print("Edit Student Information \nEnter student ID:");
        String studentID = sc.nextLine();

        for (Student student : studentList)
        {
            if (student.getID().equals(studentID))
            {
                System.out.println("Current Student Name: " + student.getName());
                System.out.print("Enter new student Name:");
                String newName = sc.nextLine();           
                student.setName(newName);

                System.out.println("Enter new student Class: ");
                String newStudentClass = sc.nextLine();
                student.setStudentClass(newStudentClass);

                while(true){
                    System.out.println("Enter new student Mark:");

                    if(sc.hasNextDouble()){
                        double newMarks = sc.nextDouble();
                        student.setMarks(newMarks);
                        sc.nextLine();
                        break;
                    }
                    else{
                        System.out.println("Ivalid! Please enter valid mark.");
                        sc.nextLine();
                    }
                }
                System.out.println("Edit student information succesful.");
            }
            else{
                System.out.println("Can not found this student.");
                sc.nextLine();
            }
        }
    }


    public static void delStudent()
    {
        viewInfor();
        sc.nextLine();
        System.out.print("Delete Student Information \nEnter student ID: ");
        String studentID = sc.nextLine();
        boolean found = false;
        for (Student student : studentList)
        {
            if(student.getID().equals(studentID))
            {
                studentList.remove(student);
                found = true;
                break;
            }
        }
        if (found)
        {
            System.out.println("Student "+ studentID+ " has been deleted");
        }
        else{
            System.out.println("Can not found this student.");
        }
    }
    public static void sortStudent(){
        int n = studentList.size();
        boolean swap;
        for (int i = 0; i < n - 1; i++){
            swap = false;
            for (int j = 0; j < n - i - 1; j++){
                if (studentList.get(j).getMarks() > studentList.get(j+1).getMarks()){
                    Student temp = studentList.get(j);
                    studentList.set(j, studentList.get(j+1));
                    studentList.set(j + 1, temp);
                    swap = true;
                }
            }
            if (swap == false){
                break;
            }
        }
        for (int i = 0; i < studentList.size(); i++){
            studentList.get(i).setRank(i+1);
            studentList.get(i).rankedStudent();
        }
        System.out.println("Sort smallest to largest mark: \n");
        for (Student student : studentList){
            System.out.println("Student ID: "+student.getID()+ "\nStudent Name: "+student.getName()+"\nStudent Class: " + student.getStudentClass() + "\nStudent Mark: " + student.getMarks() + "\nStudent Rank: " + student.getRank() +"\n-------");

        }
    }
    public static void searchStudent(){
        sc.nextLine();
        System.out.println("Search Student\nEnter student ID to search: ");
        String studentID = sc.nextLine();
        
        for (Student student : studentList){
            if (student.getID().equals(studentID)){
                System.out.println("Student Information:");
                System.out.println("Student ID: "+student.getID()+"\nStudent Name: "+student.getName()+"\nStudent Class: "+student.getStudentClass()+"\nStudent Mark: "+student.getMarks());
                return;
            }
            else{
                System.out.println("Can not found this student.");
            }
        }
    }

}