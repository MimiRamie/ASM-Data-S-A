public class Student {

    private String studentID;
    private String studentName;
    private double studentMarks;
    private String studentRank;
    private String studentClass;


    //constructor
    public Student (String studentID, String studentName, String studentClass, double studentMarks)
    {
        this.studentID =studentID;
        this.studentName =studentName;
        this.studentClass = studentClass;
        this.studentMarks = studentMarks;

    }

    //getter and setter
    public String getID()
    {
        return studentID;
    }
    public void setID(String studentID)
    {
        this.studentID = studentID;
    }
    public String getName()
    {
        return studentName;
    }
    public void setName(String studentName)
    {
        this.studentName = studentName;
    }
    public String getStudentClass()
    {
        return studentClass;
    }
    public void setStudentClass(String studentClass)
    {
        this.studentClass =  studentClass;
    }
    public double getMarks()
    {
        return studentMarks;
    }
    public void setMarks(double studentMarks)
    {
        this.studentMarks = studentMarks;
    }
    public String getRank()
    {
        return studentRank;
    }
    public void setRank(int studentRank)
    {
        this.studentRank = String.valueOf(studentRank);
    }

    public void rankedStudent(){
        if (studentMarks >= 0 && studentMarks < 5){
            System.out.println("Rank: Fail");
            studentRank = "Failed";
        }
        else if (studentMarks >= 5 && studentMarks < 6.5){
            System.out.println("Rank: Medium");
            studentRank = "Medium";
        }
        else if (studentMarks >= 6.5 && studentMarks < 7.5){
            System.out.println("Rank: Good");
            studentRank = "Good";
        }
        else if (studentMarks >= 7.5 && studentMarks < 9.0){
            System.out.println("Rank: Very good");
            studentRank = "Very Good";
        }
        else if (studentMarks >= 9.0 && studentMarks <10){
            System.out.println("Rank: Exellent");
            studentRank = "Exellent";
        }
    }

}
