package Task1;

import java.time.LocalTime;

public class Main {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String[] colors = new String[]{
            "\u001B[31m", "\u001B[32m", "\u001B[33m",
            "\u001B[34m", "\u001B[35m", "\u001B[36m",};

    public static void main(String[] args) {

        int sum = 0;
        int count = 0;
        int maxValue = 0;
        int minValue = 100;
        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (generateRandomNumber());
                if (array[i][j] > maxValue) {
                    maxValue = array[i][j];
                }
                if (array[i][j] < minValue) {
                    minValue = array[i][j];
                }
                sum += array[i][j];
                count++;
                System.out.printf(colors[array[i][j] % 6] + array[i][j] + ANSI_RESET + " ");
            }
            System.out.println("\n");
        }
        System.out.println("Max value = " + maxValue + "\n"
                + "Min value = " + minValue + "\n"
                + "Average value = " + sum / count + "\n");
    }

    private static long generateRandomNumber() {
        int maxRandomNumber = 100;
        long seed = LocalTime.now().getNano();
        int a = 48271;
        int m = 2147483647;
        seed = seed * a % m;
        return seed % maxRandomNumber;
    }
}