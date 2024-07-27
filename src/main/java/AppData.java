import java.io.*;
import java.util.Arrays;
public class AppData {
    private String[] header;
    private int[][] data;
    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }
    public void save(String csvFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
            writer.println(String.join(";", header));
            for (int[] row : data) {
                writer.println(Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .reduce((s1, s2) -> s1 + ";" + s2)
                        .orElse(""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static AppData load(String csvFile) {
        String[] header = null;
        int[][] data = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            header = reader.readLine().split(";");
            data = reader.lines()
                    .map(line -> Arrays.stream(line.split(";"))
                            .mapToInt(Integer::parseInt)
                            .toArray())
                    .toArray(int[][]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new AppData(header, data);
    }
    public static void main(String[] args) {
        String[] header = {"Value 1", "Value 2", "Value 3"};
        int[][] data = {{100, 200, 123}, {300, 400, 500}};
        AppData appData = new AppData(header, data);
        appData.save("data.csv");
        AppData loadedData = AppData.load("data.csv");
        System.out.println("Loaded Header: " + Arrays.toString(loadedData.header));
        System.out.println("Loaded Data: " + Arrays.deepToString(loadedData.data));
    }
}