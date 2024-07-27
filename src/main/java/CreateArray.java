public class CreateArray {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.print("Массив со значениями от 1 до 100: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}