public class CheckSumSign {
    public static void main(String[] args) {
        int a = 10;
        int b = -5;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
}