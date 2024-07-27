import java.util.ArrayList;
import java.util.List;

public class High {
    public static void main(String[] args) {
        List<String> collection = new ArrayList<>();
        collection.add("Highload");
        collection.add("High");
        collection.add("Load");
        collection.add("Highload");
        long countHigh = collection.stream().filter(s -> s.equals("High")).count();
        System.out.println("Количество раз, когда слово 'High' встречается в коллекции: " + countHigh);
        String firstElement = collection.stream().findFirst().orElse("0");
        System.out.println("Элемент, находящийся на первом месте в коллекции: " + firstElement);
        String lastElement = collection.stream().reduce((first, second) -> second).orElse("0");
        System.out.println("Последний элемент в коллекции: " + lastElement);
    }
}