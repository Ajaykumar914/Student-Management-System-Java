Student Management System

A console-based Student Management System developed using Java , JDBC, and MySQL.

The project allows users to add, view, search, update, and delete student records. The system was upgraded from file-based storage to a MySQL database for structured and persistent data management.

Features:-

->Add a new student
->View all students
->Search student by ID
->Update student details
->Delete student
->Input validation
->Custom exception handling
->MySQL database integration
->JDBC-based database operations

Technologies Used:-

Java
JDBC
MySQL
IntelliJ IDEA
Git & GitHub

Packages:-

->main
Contains the main application and handles user interaction through the console.

->model
Contains the Student class, which represents student information.

->service
Contains StudentManager, which performs CRUD operations using JDBC.

->exception
Contains the custom StudentNotFoundException.

->util
Contains the database connection utility.