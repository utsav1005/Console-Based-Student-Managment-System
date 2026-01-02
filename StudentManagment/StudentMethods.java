package com.StudentManagment;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentMethods {
    //1.Add Student
    //2.Update Student
    //3.Display Student
    //4.Delete Student
    static Scanner sc = new Scanner(System.in);

    //Add Student
    public static Student addStudent(List<Student> students) {

        boolean exist;
        int id;
        do {
            exist = false;
            System.out.println("Please Enter Student Id:");
            id = sc.nextInt();
            for (Student s : students) {
                if (id == s.getId()) {
                    exist = true;
                    System.out.println("id is already exists! Please enter a different id:");
                    break;
                }
            }
        } while (exist);

        sc.nextLine();
        System.out.println("Please Enter Student Name:");
        String name = sc.nextLine();
        sc.nextLine();
        System.out.println("Please Enter Student Age:");
        int age = sc.nextInt();
        sc.nextLine();

        return new Student(id, name, age);

    }

    //Update Student
    public static void updateStudent(List<Student> students) {
        System.out.println("For Update your data please enter your Student id");
        int id = sc.nextInt();
        sc.nextLine();
        Student foundStudent = null;
        for (Student s : students) {
            if (id == s.getId()) {
                foundStudent = s;
                break;
            }
        }
        if (foundStudent == null) {
            System.err.println("Student Not Found");
            return;
        }
        System.out.println("Student Found" + foundStudent);
        System.out.println("Which Details You want To update Select Any One\n" +
                "1.Update name\n" +
                "2.Update Age\n" +
                "3. Update Both\n" +
                "4.Cancel Update\n"
        );

        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                System.out.println("Enter Updated Name:");
                foundStudent.setName(sc.nextLine());
                System.out.println("Update name Successfully!!!");
                break;

            case 2:
                System.out.println("Enter Updated Age:");
                foundStudent.setAge(sc.nextInt());
                System.out.println("Update age Successfully!!!");
                break;
            case 3:
                System.out.println("Enter Updated Name:");
                String name = sc.nextLine();
                foundStudent.setName(name);
                System.out.println("Enter Updated Age:");
                int age = sc.nextInt();
                foundStudent.setName(name);
                foundStudent.setAge(age);
                System.out.println("Update name and age Successfully!!!");
                break;

            case 4:
                System.out.println("Update Cancelled Successfully!!!");
                break;

            default:
                System.err.println("Invalid Operation");
                break;
        }
    }


    //Display Student
    public static void displayStudent(List<Student> students) {
        Iterator<Student> i = students.iterator();
        while (i.hasNext()) {
            System.out.println(i.next().toString());
        }

    }

    //Delete Student
    public static void deleteStudent(List<Student> students) {
        System.out.println("Enter Student id which You want to delete it");
        int id = sc.nextInt();
        sc.nextLine();
        Student studentDelete = null;
        for (Student s : students) {
            if (id == s.getId()) {
                studentDelete = s;
                break;

            }
        }
            if (studentDelete == null) {
                System.err.println("Student not Found");
                return;
            }
            System.out.println("Student Found Successfully " + studentDelete);
            System.out.println("Are You sure You want to Delete it (Yes/No):");
            String confirms = sc.nextLine();
            if (confirms.equalsIgnoreCase("Yes")) {
                students.remove(studentDelete);
                System.out.println("Student Deleted Successfully");
            } else {
                System.out.println("Delete Operation is failed");
            }

        }
    }

