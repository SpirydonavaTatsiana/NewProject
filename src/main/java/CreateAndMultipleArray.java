public class CreateAndMultipleArray {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.print("Массив с умноженными на 2 значениями: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}