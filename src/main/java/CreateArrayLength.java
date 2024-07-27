public class CreateArrayLength {
    public static void main(String[] args) {
        int len = 5;
        int initialValue = 10;
        int[] result = createArray(len, initialValue);
        System.out.print("Созданный массив: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
    public static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}