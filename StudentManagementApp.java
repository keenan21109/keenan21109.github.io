/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.studentmanagement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Keenan
 */
class Student {
    private String studentId;
    private String name;
    private String email;
    private String course;
    private int age;
    
    public static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner (System.in);
    
    public Student(String studnetId, String name, String email, String course, int age) {
        this.studentId = studnetId;
        this.name = name;
        this.email = email;
        this.course = course;
        this.age = age;
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getCourse() {
        return course;
    }
    
    public int getAge() {
        return age;
    }
    
    @Override
    public String toString() {
        return String.format("Student ID: %s | Name: %s | Email: %s | Course: %s | Age: %d", studentId, name, email, course, age);
    }
}

public class StudentManagementApp {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int choice;
        do {
            displayMainMenu();
            try {
            choice = scanner.nextInt();
            scanner.nextLine();// Consume the newline
            switch(choice) {
                case 1:
                    captureStudent();
                    break;
                
                case 2:
                    searchStudent();
                    break;
                    
                case 3:
                    deleteStudent();
                    break;
                    
                case 4:
                    printStudentReport();
                    break;
                    
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.Please try again.");
            } 
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); //Clear invalid input
                choice = 0; //Reset choice so that the loop continues
            } 
        }while (choice != 5);
    } 
    
    private static void displayMainMenu() {
        System.out.println("\nSTUDENT MANAGEMENT APPLICATION");
        System.out.println("******************************");
        System.out.println("1. Capture a new student");
        System.out.println("2. Search for a student");
        System.out.println("3. Delete a student");
        System.out.println("4. Print student report");
        System.out.println("5. Exit The Application");
        System.out.println("Enter your choice: ");  
    }
    
    //Method to capture new student
    private static void captureStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner .nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student email: ");
        String email= scanner.nextLine();
        System.out.print("Enter student course: ");
        String course = scanner.nextLine();
        
        //Prompt for a valid age
        int age =inputValidAge();
        
        students.add(new Student(studentId, name, email, course, age));
        
        //Inform user that the student details have been successfully saved
        System.out.println("\nStudent details have been successfully saved.");
    }
    
    //Method to input a valid age(>= 16 and numeric)
    private static int inputValidAge() {
        int age = 0;
        boolean valid = false;
        
        while  (!valid) {
            System.out.print("Enter student age(Must be >= 16: ");
            try {
                age = scanner.nextInt();
                scanner.nextLine(); //Consume the newline
                if (age >= 16) {
                    valid = true;
                }else {
                    System.out.println("Invalid age. Age must be 16 or older.");
                }
            }catch (InputMismatchException e) {
                System.out.println("Inavlid input. Please enter a valid number.");
                scanner.next();//Consume invalid number
            }
        }
        return age;
    }
    
    //Method to search for student by their ID
    private static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        String studentId = scanner.nextLine();
        
        Student foundStudent = null;
        
        //Search for the student in the Array list
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                foundStudent = student;
                break;
            }
        }
        
        //Display student deatails if found, otherwise display an error message 
        if (foundStudent != null) {
            System.out.println("\nStudent found: " + foundStudent);
        }else {
            System.out.println("/Error: Student with ID '" + studentId + "' cannot be located.");
        }
    }
    
    //Method to delete a student
    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        String studentId = scanner.nextLine();
        Student studentToDelete = null;
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                studentToDelete = student;
                break;
            }
        } 
        if (studentToDelete != null) {
            students.remove(studentToDelete);
            System.out.println("Student deleted successfully.");
        
        }else {
            System.out.println("Student not found.");
        }
    }
    
    //Method to print student report
    private static void printStudentReport() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        }else {
            System.out.println("\n***Student Report***");
            System.out.printf("%-15s %-20s %-30s %-15s %-5s%n", "Student ID", "Name", "Email", "Course", "Age");
            System.out.println("---------------------------------------------------------------------------------------------");
            for (Student student : students) {
                System.out.printf("%-15s %-20s %-30s %-15s %-5d%n", student.getStudentId(), student.getName(), student.getEmail(), student.getCourse(), student.getAge());
        }
    }
}
}    
