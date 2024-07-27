import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordCounter {
    public static void main(String[] args) {
        String[] words = {
                "apple", "banana", "apple", "orange", "banana", "grape",
                "apple", "kiwi", "grape", "kiwi", "banana", "melon",
                "melon", "apple", "orange", "kiwi", "grape", "melon"
        };
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }
        System.out.println("Уникальные слова: " + uniqueWords);
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("Количество вхождений каждого слова:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}