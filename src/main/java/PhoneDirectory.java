import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {
    private Map<String, List<String>> directory;
    public PhoneDirectory() {
        this.directory = new HashMap<>();
    }
    public void add(String surname, String phoneNumber) {
        if (!directory.containsKey(surname)) {
            directory.put(surname, new ArrayList<>());
        }
        directory.get(surname).add(phoneNumber);
    }
    public List<String> get(String surname) {
        return directory.getOrDefault(surname, new ArrayList<>());
    }
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add("Ivanov", "123-456-789");
        phoneDirectory.add("Petrov", "987-654-321");
        phoneDirectory.add("Ivanov", "111-222-333");
        phoneDirectory.add("Sidorov", "555-666-777");
        System.out.println("Номера для Ivanov: " + phoneDirectory.get("Ivanov"));
        System.out.println("Номера для Petrov: " + phoneDirectory.get("Petrov"));
        System.out.println("Номера для Sidorov: " + phoneDirectory.get("Sidorov"));
        System.out.println("Номера для Smirnov: " + phoneDirectory.get("Smirnov"));
    }
}