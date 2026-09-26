package service;


import exception.StudentNotFoundException;
import model.Student;


import util.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentManager {


     // ADD STUDENT

        public void addStudent(Student student) {

            String sql = "INSERT INTO Students (id, name, course, age) VALUES (?, ?, ?, ?)";

            try (Connection con = DB_Connection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, student.getId());
                ps.setString(2, student.getName());
                ps.setString(3, student.getCourse());
                ps.setInt(4, student.getAge());

                ps.executeUpdate();

                System.out.println("Student Added Successfully.");

            } catch (SQLException e) {
                System.out.println("Error adding student.");
                e.printStackTrace();
            }
        }

    // VIEW STUDENTS
    public void viewStudents() {

        String sql = "SELECT * FROM Students";

        try (Connection con = DB_Connection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("----------------------");
            }

            if (!found) {
                System.out.println("No Students Found.");
            }

        } catch (SQLException e) {
            System.out.println("Error viewing students.");
            e.printStackTrace();
        }
    }

    // SEARCH STUDENTS
  public Student searchStudent(int id ) throws StudentNotFoundException{


      String sql = "SELECT * FROM Students WHERE id = ?";

      try (Connection con = DB_Connection.getConnection();
           PreparedStatement ps = con.prepareStatement(sql)) {

          ps.setInt(1, id);

          try (ResultSet rs = ps.executeQuery()) {

              if (rs.next()) {

                  return new Student(
                          rs.getInt("id"),
                          rs.getString("name"),
                          rs.getInt("age"),
                          rs.getString("course")
                  );
              }
          }

      } catch (SQLException e) {

          System.out.println("Database error while searching student.");
          e.printStackTrace();
      }

      throw new StudentNotFoundException(
              "Student with Id " + id + " not found."
      );
  }

    // DELETE STUDENT
    public void deleteStudent(int id) {

        String sql = "DELETE FROM Students WHERE id = ?";

        try (Connection con = DB_Connection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted.");
            } else {
                System.out.println("Student Not Found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting student.");
            e.printStackTrace();
        }
    }

    // UPDATE STUDENT
    public void updateStudent(int id, String name, int age, String course) {

        String sql = "UPDATE Students SET name = ?, age = ?, course = ? WHERE id = ?";

        try (Connection con = DB_Connection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated.");
            } else {
                System.out.println("Student Not Found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating student.");
            e.printStackTrace();
        }
    }
}

    

