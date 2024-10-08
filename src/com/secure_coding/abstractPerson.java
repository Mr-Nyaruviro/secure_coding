package com.secure_coding;

import java.util.Scanner;

abstract class abstractPerson {
    private int personAge;
    private char personGender;
    private String personName;

    public abstractPerson(String personName, int personAge, char personGender){
        this.personAge = personAge;
        this.personName = personName;
        this.personGender = personGender;
    }

    public String getPersonName() {
        return personName;
    }

    public char getPersonGender() {
        return personGender;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonName(String personName) {
        if(!personName.equalsIgnoreCase("ISA") && !personName.contains("Sadza")){
            this.personName = personName;
        }else {
            System.out.println("Please enter a valid Name");
        }
    }

    public void setPersonAge(int personAge) {
        if (personAge >= 18) {
            this.personAge = personAge;
        } else {
            System.out.println("Grow up");
        }
    }

    public void setPersonGender(char personGender) {
        if (personGender == 'M' || personGender == 'F'){
            this.personGender = personGender;
        }else {
            System.out.println("Enter M or F");
        }
    }



    public abstract void display();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        abstractPerson person;

        System.out.println("Enter your Name: ");
        String n = scanner.nextLine();

        System.out.println("Enter your Gender: ");
        char g = scanner.nextLine().charAt(0);

        System.out.println("Enter your Age: ");
        int a = scanner.nextInt();

        System.out.println("Are you a Student or HLecturer (S/L)? ");
        char p = scanner.nextLine().charAt(0);

        switch (p){
            case 'S':
                System.out.println("Enter Student ID: ");
                String studentId = scanner.nextLine();
                person = new Student(a, g, n, studentId);
                break;
            case 'L':
                System.out.println("Enter HLecturer ID: ");
                String subject = scanner.nextLine();
                person = new Lecturer(a, g, n, subject);
                break;
            default:
                System.out.println("Enter a valid choice");
                return;
        }

        person.display();
        scanner.close();
    }
}
class Student extends abstractPerson{
    // By making studentId final, you ensure that the student's identity remains consistent and cannot be accidentally modified.
    private final String studentId;

    public Student(int personAge, char personGender, String personName, String studentId){
        super(personName, personAge, personGender);
        this.studentId = studentId;
    }

    /*
    The @Override annotation is used to indicate that this method is
    intended to override a method from a superclass or interface.

    It helps prevent accidental method overloads and improves
    code maintainability by making it clear that the method is overriding an existing one.
     */
    @Override
    public void display(){
        System.out.println("Student Name: " + getPersonName());
        System.out.println("Student Age: " + getPersonAge());
        System.out.println("Student Gender: " + getPersonGender());
        System.out.println("Student StudentID: " + studentId);
    }
}

class Lecturer extends abstractPerson{
    private final String subject;

    public Lecturer(int personAge, char personGender, String personName, String subject){
        super(personName, personAge, personGender);
        this.subject = subject;
    }

    @Override
    public void display(){
        System.out.println("HLecturer Name: " + getPersonName());
        System.out.println("HLecturer Age: " + getPersonAge());
        System.out.println("HLecturer Gender: " + getPersonGender());
        System.out.println("HLecturer Subject: " + subject);
    }
}