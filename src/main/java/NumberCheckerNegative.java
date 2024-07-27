public class NumberCheckerNegative {
    public static boolean isNegative(int number) {
        return number < 0;
    }
    public static void main(String[] args) {
        System.out.println(isNegative(10));
        System.out.println(isNegative(-5));
        System.out.println(isNegative(0));
    }
}