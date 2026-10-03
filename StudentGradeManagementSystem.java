import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student {
    private int id;
    private String name;
    private Map<String, Integer> grades; // subject → marks

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new HashMap<>();
    }

    public void addGrade(String subject, int marks) {
        grades.put(subject, marks);
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public double calculateAverage() {
        int total = 0;
        for (int marks : grades.values()) {
            total += marks;
        }
        return grades.size() > 0 ? (double) total / grades.size() : 0;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Grades: " + grades;
    }
}

public class StudentGradeManagementSystem {
    private List<Student> students;

    public StudentGradeManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayAllStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void displayTopper() {
        Student topper = null;
        double highestAvg = 0;
        for (Student s : students) {
            double avg = s.calculateAverage();
            if (avg > highestAvg) {
                highestAvg = avg;
                topper = s;
            }
        }
        if (topper != null) {
            System.out.println("Topper: " + topper.getName() + " with average " + highestAvg);
        }
    }

    public static void main(String[] args) {
        StudentGradeManagementSystem system = new StudentGradeManagementSystem();

        Student s1 = new Student(1, "Alice");
        s1.addGrade("Math", 85);
        s1.addGrade("Science", 90);

        Student s2 = new Student(2, "Bob");
        s2.addGrade("Math", 70);
        s2.addGrade("Science", 75);
        s2.addGrade("English", 80);

        Student s3 = new Student(3, "Charlie");
        s3.addGrade("Math", 95);
        s3.addGrade("Science", 92);

        system.addStudent(s1);
        system.addStudent(s2);
        system.addStudent(s3);

        System.out.println("All Students:");
        system.displayAllStudents();

        System.out.println("\nTopper:");
        system.displayTopper();
    }
}
