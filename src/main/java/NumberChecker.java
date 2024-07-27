public class NumberChecker {
    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println("Число " + number + " положительное.");
        } else {
            System.out.println("Число " + number + " отрицательное.");
        }
    }
    public static void main(String[] args) {
        checkNumber(10000);
        checkNumber(-558);
        checkNumber(0);
    }
}