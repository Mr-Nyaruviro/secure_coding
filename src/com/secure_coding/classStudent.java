package com.secure_coding;

import java.util.Scanner;

/*
classStudent is Encapsulated for:
    Security
    Enhancement
    Modularity
 */

public class classStudent {
//    We have used private members to implement data hiding
//    This is a Tightly Encapsulated Class because it has all private methods
    private int studentAge;
    private char studentGender;
    private String studentName;

    // Getters and Setters for updating the Methods
    public String getStudentName() {
        //validations
        return studentName;
    }

    public char getStudentGender() {
        return studentGender;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentName(String studentName) {
        //validations
        if(!studentName.equalsIgnoreCase("ISA") && !studentName.contains("Sadza")){
            this.studentName = studentName; //Refer
        }else {
            System.out.println("Please enter a valid Name");
        }
    }

    public void setStudentAge(int studentAge) {
        if (studentAge >= 18) {
            this.studentAge = studentAge;
        } else {
            System.out.println("Grow up");
        }
    }

    public void setStudentGender(char studentGender) {
        if (studentGender == 'M' || studentGender == 'F'){
            this.studentGender = studentGender;
        }else {
            System.out.println("Enter M or F");
        }
    }

    //constructor
    public classStudent(String studentName, int studentAge, char studentGender){
        this.studentAge = studentAge;
        this.studentName = studentName;
        this.studentGender = studentGender;
    }

    //Method
    public void display(){
        System.out.println("Student Name: " + studentName);
        System.out.println("Student Age: " + studentAge);
        System.out.println("Student Gender: " + studentGender);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your Name: ");
        String n = scanner.nextLine();

        System.out.println("Enter your Gender: ");
        char g = scanner.nextLine().charAt(0);

        System.out.println("Enter your Age: ");
        int a = scanner.nextInt();

        classStudent s = new classStudent(n, a, g);
        s.display();
    }
}
