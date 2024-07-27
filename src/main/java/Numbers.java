import java.util.Arrays;
import java.util.Random;

public class Numbers {
    public static void main(String[] args) {
        int[] numbers = generateRandomNumbers(10, 1, 100);
        long evenCount = Arrays.stream(numbers).filter(num -> num % 2 == 0).count();
        System.out.println("Сгенерированный набор чисел:");
        Arrays.stream(numbers).forEach(num -> System.out.print(num + " "));
        System.out.println("\nКоличество чётных чисел: " + evenCount);
    }
    public static int[] generateRandomNumbers(int count, int min, int max) {
        int[] numbers = new int[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            numbers[i] = random.nextInt((max - min) + 1) + min;
        }
        return numbers;
    }
}