public class SumInRangeChecker {
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }
    public static void main(String[] args) {
        System.out.println(isSumInRange(4, 5));
        System.out.println(isSumInRange(7, 3));
        System.out.println(isSumInRange(11, 10));
        System.out.println(isSumInRange(15, 5));
    }
}