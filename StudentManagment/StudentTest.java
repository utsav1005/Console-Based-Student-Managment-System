package com.StudentManagment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentTest {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        do{
            System.out.println("Student Management System ");
            System.out.println("1. Add Student \n" +
                    "2. Update Student\n" + "3. Display All Students\n"+
                    "4. Delete Student\n" + "5. Exit\n");
            System.out.println("Please Select Operation:");
            int choise = sc.nextInt();
            switch(choise){
                case 1 :
                    Student student =  StudentMethods.addStudent(studentList);
                    studentList.add(student);
                    System.out.println("Student Added Successfully.");
                        break;

                case 2 :
                    StudentMethods.updateStudent(studentList);
                    break;

                case 3 :
                    StudentMethods.displayStudent(studentList);
                    break;

                case 4 :
                        StudentMethods.deleteStudent(studentList);
                        break;

                case 5 :
                        System.exit(0);
                        break;

                default :
                    System.err.println("Invalid Operation");
                        break;
            }
        }while(true);
    }
}
