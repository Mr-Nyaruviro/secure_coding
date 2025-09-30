// Interface for student operations
// Interfaces define what methods a class must implement
public interface StudentOperations {
    // Abstract methods (no implementation - just method signatures)
    void enroll(String course);
    void dropCourse(String course);
    double calculateGPA();
    void displayStudentInfo();

    // Constant variable (public static final by default)
    // This cannot be changed - it's a constant
    int MAX_COURSES = 6;
}