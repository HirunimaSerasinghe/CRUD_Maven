package StudentManagement.dao;

import StudentManagement.model.StudentModel;


import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.sun.xml.internal.bind.v2.model.core.ID;

public class StudentDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/crud";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Hiru_98_sere";

    private static final String InsertStudent_SQL = "INSERT INTO student" + "  (StudentName, StudentAge, StudentEmail) VALUES " + " (?, ?, ?);";
    private static final String SelectStudentById_SQL = "select ID, StudentName, StudentAge, StudentEmail from student where ID =?;";
    private static final String SelectAllStudents_SQL = "select * from student;";
    private static final String DeleteStudent_SQL = "delete from student where ID = ?;";
    private static final String UpdateStudent_SQL = "update student set StudentName = ?, StudentAge=?, StudentEmail= ? where ID = ?;";

    public StudentDao() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void InsertStudent(StudentModel Student) throws SQLException {
        System.out.println(InsertStudent_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(InsertStudent_SQL)) {
            preparedStatement.setString(1, Student.getStudentName());
            preparedStatement.setString(2, Student.getStudentAge());
            preparedStatement.setString(3, Student.getStudentEmail());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public StudentModel SelectStudent(int id) {
        StudentModel Student = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SelectStudentById_SQL)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("StudentName");
                String age = rs.getString("StudentAge");
                String email = rs.getString("StudentEmail");
                Student = new StudentModel(id, name, age, email);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return Student;
    }

    public List<StudentModel> SelectAllStudents() {

        List<StudentModel> Students = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SelectAllStudents_SQL)) {

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("StudentName");
                String age = rs.getString("StudentAge");
                String email = rs.getString("StudentEmail");
                Students.add(new StudentModel(id, name, age, email));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return Students;
    }

    public boolean DeleteStudent(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DeleteStudent_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean UpdateStudent(StudentModel Student) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UpdateStudent_SQL)) {
            statement.setString(1, Student.getStudentName());
            statement.setString(2, Student.getStudentAge());
            statement.setString(3, Student.getStudentEmail());
            statement.setInt(4, Student.getID());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
