package com.secure_coding;

import java.util.Scanner;

interface interfacePerson {
    String getPersonName();

    char getPersonGender();

    int getPersonAge();

    void setPersonName(String personName);

    void setPersonAge(int personAge);

    void setPersonGender(char personGender);

    // Abstract method for displaying information (implemented in concrete classes)
    void display();
}

class HStudent implements interfacePerson {
    // By making studentId final, you ensure that the student's identity remains consistent and cannot be accidentally modified.
    private final String studentId;
    private String personName;
    private int personAge;
    private char personGender;


    public HStudent(int personAge, char personGender, String personName, String studentId) {
        this.personAge = personAge;
        this.personGender = personGender;
        this.personName = personName;
        this.studentId = studentId;

        // Validation logic can be moved to setters here if needed
        if (!validateName(personName)) {
            System.out.println("Please enter a valid Name");
        }
        if (personAge < 18) {
            System.out.println("Grow up");
        }
        if (personGender != 'M' && personGender != 'F') {
            System.out.println("Enter M or F");
        }
    }

    private boolean validateName(String name) {
        return !name.equalsIgnoreCase("ISA") && !name.contains("Sadza");
    }

    @Override
    public String getPersonName() {
        return personName;
    }

    @Override
    public char getPersonGender() {
        return personGender;
    }

    @Override
    public int getPersonAge() {
        return personAge;
    }

    @Override
    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    @Override
    public void setPersonGender(char personGender) {
        this.personGender = personGender;
    }

    @Override
    public void display() {
        System.out.println("HStudent Name: " + getPersonName());
        System.out.println("HStudent Age: " + getPersonAge());
        System.out.println("HStudent Gender: " + getPersonGender());
        System.out.println("HStudent StudentID: " + studentId);
    }
}

class HLecturer implements interfacePerson {
    private final String subject;
    private String personName;
    private int personAge;
    private char personGender;

    public HLecturer(int personAge, char personGender, String personName, String subject) {
        this.personAge = personAge;
        this.personGender = personGender;
        this.personName = personName;
        this.subject = subject;

        // Validation logic can be moved to setters here if needed
        if (!validateName(personName)) {
            System.out.println("Please enter a valid Name");
        }
        if (personAge < 18) {
            System.out.println("Grow up");
        }
        if (personGender != 'M' && personGender != 'F') {
            System.out.println("Enter M or F");
        }
    }

    private boolean validateName(String name) {
        return !name.equalsIgnoreCase("ISA") && !name.contains("Sadza");
    }

    @Override
    public String getPersonName() {
        return personName;
    }

    @Override
    public char getPersonGender() {
        return personGender;
    }

    @Override
    public int getPersonAge() {
        return personAge;
    }

    @Override
    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    @Override
    public void setPersonGender(char personGender) {
        this.personGender = personGender;
    }

    @Override
    public void display() {
        System.out.println("HLecturer Name: " + getPersonName());
        System.out.println("HLecturer Age: " + getPersonAge());
        System.out.println("HLecturer Gender: " + getPersonGender());
        System.out.println("HLecturer Subject: " + subject);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        interfacePerson person;

        System.out.println("Enter your Name: ");
        String n = scanner.nextLine();

        System.out.println("Enter your Gender: ");
        char g = scanner.nextLine().charAt(0);

        System.out.println("Enter your Age: ");
        int a = scanner.nextInt();

        System.out.println("Are you a HStudent or HLecturer (S/L)? ");
        char p = scanner.nextLine().charAt(0);

        switch (p) {
            case 'S':
                System.out.println("Enter HStudent ID: ");
                String studentId = scanner.nextLine();
                person = new HStudent(a, g, n, studentId);
                break;
            case 'L':
                System.out.println("Enter HLecturer ID: ");
                String subject = scanner.nextLine();
                person = new HLecturer(a, g, n, subject);
                break;
            default:
                System.out.println("Enter a valid choice");
                return;
        }

        person.display();
        scanner.close();
    }
}