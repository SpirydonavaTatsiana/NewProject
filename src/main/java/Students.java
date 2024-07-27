import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Students {
    private String name;
    private int age;
    private String gender;
    public Students(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public static void main(String[] args) {
        List<Students> students = Arrays.asList(
                new Students("Alice", 22, "female"),
                new Students("Bob", 25, "male"),
                new Students("Charlie", 20, "male"),
                new Students("Diana", 18, "female"),
                new Students("Eve", 30, "female")
        );
        double averageAgeOfMales = students.stream()
                .filter(s -> s.getGender().equals("male"))
                .mapToInt(Students::getAge)
                .average()
                .orElse(0.0);
        System.out.println("Средний возраст студентов мужского пола: " + averageAgeOfMales);
        List<String> studentsWhoGetConscription = new ArrayList<>();
        for (Students s : students) {
            if (s.getGender().equals("male") && s.getAge() >= 18 && s.getAge() <= 27) {
                String students1Name = s.getName();
                studentsWhoGetConscription.add(students1Name);
            }
        }
        System.out.println("Студентам мужского пола грозит получение повестки: " + studentsWhoGetConscription);
    }
}