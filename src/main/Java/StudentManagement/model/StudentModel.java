package StudentManagement.model;

public class StudentModel {
    protected int ID;
    protected String StudentName;
    protected String StudentAge;
    protected String StudentEmail;

    public StudentModel() {
    }

    public StudentModel(int ID, String StudentName, String StudentAge, String StudentEmail) {
        this.ID = ID;
        this.StudentName = StudentName;
        this.StudentAge = StudentAge;
        this.StudentEmail = StudentEmail;
    }

    public StudentModel(String StudentName, String StudentAge, String StudentEmail) {
        this.StudentName = StudentName;
        this.StudentAge = StudentAge;
        this.StudentEmail = StudentEmail;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getStudentAge() {
        return StudentAge;
    }

    public void setStudentAge(String StudentAge) {
        this.StudentAge = StudentAge;
    }

    public String getStudentEmail() {
        return StudentEmail;
    }

    public void setStudentEmail(String StudentEmail) {
        this.StudentEmail = StudentEmail;
    }


}
