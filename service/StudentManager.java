package service;

import model.Student;
import util.FileHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class StudentManager {
    

    ArrayList<Student> students = new ArrayList<>();
    private FileHandler fileHandler = new FileHandler();

     private final String FILE_NAME = "students.txt";

     // ADD STUDENT
    public void addStudent(Student student) {

    for (Student s : students) {
        if (s.getId() == student.getId()) {
            System.out.println("model.Student ID already exists!");
            return;
        }
    }

    students.add(student);
    saveStudents();
    System.out.println("model.Student Added Successfully.");
}

    // VIEW STUDENTS
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    // SEARCH STUDENTS
    public void searchStudent(int id) {

        for (Student s : students) {

            if (s.getId() == id) {
                s.display();
                return;
            }
        }

        System.out.println("model.Student Not Found.");
    }

    // DELETE STUDENT
    public void deleteStudent(int id) {

        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()){
            Student s = iterator.next();
            if (s.getId() == id) {

                students.remove(s);
                System.out.println("model.Student Deleted.");
                return;
            }
        }

        System.out.println("model.Student Not Found.");
    }

    // UPDATE STUDENT
    public void updateStudent(int id, String name, int age, String course) {

        for (Student s : students) {

            if (s.getId() == id) {

                s.setName(name);
                s.setAge(age);
                s.setCourse(course);
                saveStudents();

                System.out.println("model.Student Updated.");
                return;
            }
        }

        System.out.println("model.Student Not Found.");
    
    }

    // to load data
    public void loadStudents(){
        students = fileHandler.loadFromFile();
    }

    // to save data
    public void saveStudents(){
        fileHandler.saveToFile(students);
    }
}

    

