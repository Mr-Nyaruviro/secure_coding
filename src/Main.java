public class Main {
    public static void main(String[] args) {

        System.out.println("=== DEMONSTRATING CONSTRUCTORS ===");

        // Using Default Constructor - no parameters
        System.out.println("\n1. Creating student with default constructor:");
        Student student1 = new Student();
        student1.displayStudentInfo();

        // Using Parameterized Constructor - with name and ID
        System.out.println("\n2. Creating student with parameterized constructor:");
        Student student2 = new Student("Alice Johnson", 2023001);
        student2.enroll("Mathematics");
        student2.enroll("Computer Science");
        student2.calculateGPA();
        student2.displayStudentInfo();

        // Using Overloaded Constructor - with name, ID and initial GPA
        System.out.println("\n3. Creating student with overloaded constructor:");
        Student student3 = new Student("Bob Smith", 2023002, 3.8);
        student3.enroll("Physics");
        student3.enroll("Chemistry");
        student3.enroll("Biology");
        student3.displayStudentInfo();

        // Demonstrating course operations
        System.out.println("\n=== COURSE OPERATIONS ===");
        student2.enroll("Physics");
        student2.enroll("English");
        student2.displayStudentInfo();

        student2.dropCourse("Mathematics");
        student2.displayStudentInfo();

        // Accessing interface constant
        System.out.println("\nInterface constant: Maximum courses allowed = " + StudentOperations.MAX_COURSES);
    }
}