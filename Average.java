import java.util.Scanner;

public class Average {
    private int[] data;
    private double mean;

    public Average() {
        data = new int[5];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < data.length; i++) {
            System.out.print("Enter score number " + (i + 1) + ": ");
            data[i] = scanner.nextInt();
        }

        scanner.close();

        selectionSort();
        calculateMean();
    }

    public void calculateMean() {
        double total = 0;

        for (int score : data) {
            total += score;
        }

        mean = total / data.length;
    }

    public void selectionSort() {
        for (int startScan = 0; startScan < (data.length - 1); startScan++) {
            int minIndex = startScan;
            int minValue = data[startScan];

            for (int index = startScan + 1; index < data.length; index++) {
                if (data[index] > minValue) {
                    minValue = data[index];
                    minIndex = index;
                }
            }

            int temp = data[minIndex];
            data[minIndex] = data[startScan];
            data[startScan] = temp;
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder("Sorted scores (highest to lowest): ");
        for (int score : data) {
            result.append(score).append(" ");
        }
        result.append("\nMean: ").append(mean);
        return result.toString();
    }
}
