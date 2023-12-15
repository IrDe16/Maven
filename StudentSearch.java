import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentSearchApp {
    private List<Student> students;

    public StudentSearch(List<Student> students) {
        this.students = students;
    }

    public List<Student> searchByName(String name) {
        return students.stream()
                .filter(student -> student.getFirst_name().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Student> searchByGender(String gender) {
        return students.stream()
                .filter(student -> student.getGender().equalsIgnoreCase(gender))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Caleb", "3.6", "jdtg0@aws.com", "Female"));
        studentList.add(new Student(2, "Aida", "3.1", "adattt@test.gov", "Female"));
        studentList.add(new Student(3, "Alex", "3.4", "Adavis@bccs.com", "Male"));
        studentList.add(new Student(4, "Meba", "3.2", "mtravis@yahoo.com", "Male"));

        StudentSearchApp studentSearchApp = new StudentSearchApp(studentList);

        // Example: Searching by name
        String searchName = "Caleb";
        List<Student> resultByName = studentSearchApp.searchByName(searchName);
        System.out.println("Search result for name '" + searchName + "':");
        resultByName.forEach(System.out::println);

        // Example: Searching by gender
        String searchGender = "Female";
        List<Student> resultByGender = studentSearchApp.searchByGender(searchGender);
        System.out.println("\nSearch result for gender '" + searchGender + "':");
        resultByGender.forEach(System.out::println);
    }
}