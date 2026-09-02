package util;
import model.Student;

import  java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private final String File_Name = "students.txt";

    public void saveToFile(ArrayList<Student> students){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(File_Name))){
            for (Student s : students){
                writer.write(s.getId() + "," +
                        s.getName() + "," +
                        s.getAge() + "," +
                        s.getCourse());
                writer.newLine();
            }

        }
        catch (IOException e){
            System.out.println("Error while saving file.");
        }

    }
    public ArrayList<Student> loadFromFile() {

        ArrayList<Student> students = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(File_Name))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];

                students.add(
                        new Student(id, name, age, course)
                );
            }

        } catch (IOException e) {
            System.out.println("No previous data found.");
        }

        return students;
    }
}
