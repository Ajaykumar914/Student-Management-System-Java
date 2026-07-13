import java.util.*;
public class studentProject {
  
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManager manager = new StudentManager();
        manager.loadFromFile();

        while (true) {

            System.out.println("\n===== Student Management System =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age : ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course : ");
                    String course = sc.nextLine();

                    manager.addStudent(new Student(id, name, age, course));

                    break;

                case 2:

                    manager.viewStudents();

                    break;

                case 3:

                    System.out.print("Enter Student ID : ");

                    manager.searchStudent(sc.nextInt());

                    break;

                case 4:

                    System.out.print("Enter ID : ");

                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Name : ");

                    name = sc.nextLine();

                    System.out.print("New Age : ");

                    age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Course : ");

                    course = sc.nextLine();

                    manager.updateStudent(id, name, age, course);

                    break;

                case 5:

                    System.out.print("Enter Student ID : ");

                    manager.deleteStudent(sc.nextInt());

                    break;

                case 6:

                    
                    manager.saveToFile();
                    System.out.println("Thank You.");
                    sc.close();
                    System.exit(0);;

                default:

                    System.out.println("Invalid Choice.");
            }
        }
    }
} 

