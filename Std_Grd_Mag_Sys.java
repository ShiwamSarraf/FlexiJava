import java.util.ArrayList;
import java.util.List;

class Student {
    String name;
    List<Double> grades = new ArrayList<>();

    Student(String name) { this.name = name; }

    void addGrade(double grade) { grades.add(grade); }

    double calculateAverage() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (double g : grades) sum += g;
        return sum / grades.size();
    }

    void displayStudentDetails() {
        System.out.println("Student: " + name + " | Grades: " + grades + " | Avg: " + calculateAverage());
    }
}

class GradeManager {
    List<Student> students = new ArrayList<>();

    void addStudent(Student s) { students.add(s); }

    void displayAllStudents() {
        for (Student s : students) s.displayStudentDetails();
    }
}
public class Std_Grd_Mag_Sys {
    public static void main(String[] args) {
        GradeManager gm = new GradeManager();
        Student s1 = new Student("Poshak");
        s1.addGrade(85.5);
        s1.addGrade(90.0);
        gm.addStudent(s1);
        gm.displayAllStudents();
    }
    
}
