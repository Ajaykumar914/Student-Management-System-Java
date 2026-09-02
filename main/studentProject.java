package main;

import model.Student;
import service.StudentManager;

import java.util.*;
public class studentProject {    // its the Main Class
  
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManager manager = new StudentManager();
        manager.loadStudents();

        while (true) {

            System.out.println("\n===== model.Student Management System =====");

            System.out.println("1. Add model.Student");
            System.out.println("2. View Students");
            System.out.println("3. Search model.Student");
            System.out.println("4. Update model.Student");
            System.out.println("5. Delete model.Student");
            System.out.println("6. Exit");

            System.out.print("Enter Choice : ");

            int choice ;
            try{
                choice = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Invalid choice. Please enter a number");
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter ID : ");
                    int id ;
                    try{
                        id = Integer.parseInt(sc.nextLine());
                    }
                    catch (NumberFormatException e){
                        System.out.println("Invalid ID.");
                        break;
                    }

                    System.out.print("Enter Name : ");
                    String name = sc.nextLine().trim();

                    if (name.isEmpty()){
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Age : ");
                    int age ;
                   try{
                       age = Integer.parseInt(sc.nextLine());
                   }
                   catch(NumberFormatException e){
                       System.out.println("Invalid age.");
                       break;
                   }
                    if (age <= 0) {

                        System.out.println(
                                "Age must be greater than 0.");

                        break;
                    }

                    System.out.print("Enter Course : ");
                    String course = sc.nextLine().trim();
                    if (course.isEmpty()){
                        System.out.println("Course cannot be empty.");
                        break;
                    }

                    Student student = new Student(id , name , age , course);

                    manager.addStudent(student);

                    break;

                case 2:

                    manager.viewStudents();

                    break;

                case 3:

                    System.out.print("Enter model.Student ID : ");

                    try {

                        id = Integer.parseInt(sc.nextLine());

                        manager.searchStudent(id);

                    } catch (NumberFormatException e) {

                        System.out.println(
                                "Invalid ID.");
                    }

                    break;

                case 4:

                    System.out.print("Enter ID : ");

                    try {

                        id = Integer.parseInt(sc.nextLine());

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid ID.");
                        break;
                    }

                    System.out.print("New Name : ");

                    name = sc.nextLine().trim();

                    if (name.isEmpty()) {

                        System.out.println(
                                "Name cannot be empty.");

                        break;
                    }

                    System.out.print("New Age : ");

                    try {

                        age = Integer.parseInt(sc.nextLine());

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid age.");
                        break;
                    }


                    if (age <= 0) {

                        System.out.println(
                                "Age must be greater than 0.");

                        break;
                    }

                    System.out.print("New Course : ");

                    course = sc.nextLine().trim();
                    if (course.isEmpty()) {

                        System.out.println(
                                "Course cannot be empty.");

                        break;
                    }

                    manager.updateStudent(id, name, age, course);

                    break;

                case 5:

                    System.out.print("Enter model.Student ID : ");

                    try {

                        id = Integer.parseInt(sc.nextLine());

                        manager.deleteStudent(id);

                    } catch (NumberFormatException e) {

                        System.out.println(
                                "Invalid ID.");
                    }

                    break;

                case 6:
                    manager.saveStudents();
                    System.out.println("Thank You for using model.Student Management System.");
                    sc.close();
                   return;

                default:

                    System.out.println("Invalid Choice.Please choose 1-6.");
            }
        }
    }
} 

