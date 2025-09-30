// Student class implementing the interface
class Student implements StudentOperations {
    // Student attributes (instance variables)
    private String name;
    private int id;
    private double gpa;
    private String[] enrolledCourses;
    private int courseCount;

    // ========== CONSTRUCTORS ==========

    // Default Constructor - creates student with default values
    public Student() {
        this.name = "Unknown";
        this.id = 0;
        this.gpa = 0.0;
        this.enrolledCourses = new String[MAX_COURSES];
        this.courseCount = 0;
        System.out.println("Default constructor called - Student created with default values");
    }

    // Parameterized Constructor - creates student with specific name and ID
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.gpa = 0.0;
        this.enrolledCourses = new String[MAX_COURSES];
        this.courseCount = 0;
        System.out.println("Parameterized constructor called - Student: " + name + " (ID: " + id + ")");
    }

    // Overloaded Constructor - creates student with name, ID and initial GPA
    public Student(String name, int id, double initialGPA) {
        this.name = name;
        this.id = id;
        this.gpa = initialGPA;
        this.enrolledCourses = new String[MAX_COURSES];
        this.courseCount = 0;
        System.out.println("Overloaded constructor called - Student: " + name + " (ID: " + id + ", GPA: " + initialGPA + ")");
    }

    // ========== INTERFACE METHOD IMPLEMENTATIONS ==========

    @Override
    public void enroll(String course) {
        if (courseCount < MAX_COURSES) {
            enrolledCourses[courseCount] = course;
            courseCount++;
            System.out.println("Enrolled in: " + course);
        } else {
            System.out.println("Cannot enroll in " + course + " - maximum courses reached!");
        }
    }

    @Override
    public void dropCourse(String course) {
        for (int i = 0; i < courseCount; i++) {
            if (enrolledCourses[i].equals(course)) {
                // Shift courses to remove the dropped one
                for (int j = i; j < courseCount - 1; j++) {
                    enrolledCourses[j] = enrolledCourses[j + 1];
                }
                courseCount--;
                System.out.println("Dropped: " + course);
                return;
            }
        }
        System.out.println("Course not found: " + course);
    }

    @Override
    public double calculateGPA() {
        // Simple GPA calculation example
        this.gpa = 3.0 + (Math.random() * 1.5); // Random GPA between 3.0-4.5
        return gpa;
    }

    @Override
    public void displayStudentInfo() {
        System.out.println("\n=== STUDENT INFORMATION ===");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("GPA: " + String.format("%.2f", gpa));
        System.out.println("Courses enrolled: " + courseCount + "/" + MAX_COURSES);
        System.out.print("Courses: ");
        for (int i = 0; i < courseCount; i++) {
            System.out.print(enrolledCourses[i] + " ");
        }
        System.out.println();
    }
}