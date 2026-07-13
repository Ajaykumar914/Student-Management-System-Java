import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentManager {
    

    ArrayList<Student> students = new ArrayList<>();
     private final String FILE_NAME = "students.txt";

    public void addStudent(Student student) {

    for (Student s : students) {
        if (s.getId() == student.getId()) {
            System.out.println("Student ID already exists!");
            return;
        }
    }

    students.add(student);
    System.out.println("Student Added Successfully.");
}

    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    public void searchStudent(int id) {

        for (Student s : students) {

            if (s.getId() == id) {
                s.display();
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    public void deleteStudent(int id) {

        for (Student s : students) {

            if (s.getId() == id) {

                students.remove(s);
                System.out.println("Student Deleted.");
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    public void updateStudent(int id, String name, int age, String course) {

        for (Student s : students) {

            if (s.getId() == id) {

                s.setName(name);
                s.setAge(age);
                s.setCourse(course);

                System.out.println("Student Updated.");
                return;
            }
        }

        System.out.println("Student Not Found.");
    
    }


 public void saveToFile() {

    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));

        for (Student s : students) {

            writer.write(
                    s.getId() + "," +
                    s.getName() + "," +
                    s.getAge() + "," +
                    s.getCourse());

            writer.newLine();
        }

        writer.close();

        System.out.println("Students saved successfully.");

    } catch (IOException e) {
        System.out.println("Error while saving file.");
    }
}

    public void loadFromFile() {

    try {

        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));

        String line;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",");

            int id = Integer.parseInt(data[0]);
            String name = data[1];
            int age = Integer.parseInt(data[2]);
            String course = data[3];

            students.add(new Student(id, name, age, course));
        }

        reader.close();

    } catch (IOException e) {

        System.out.println("No previous data found.");
    }
}
}
    

