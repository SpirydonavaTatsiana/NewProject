public class PrinterCountString {
    public static void printCountString(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }
    public static void main(String[] args) {
        printCountString("Hello, Tatsiana!", 4);
        printCountString("It is very difficult!", 6);
    }
}
