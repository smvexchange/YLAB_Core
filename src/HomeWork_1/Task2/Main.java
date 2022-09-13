package HomeWork_1.Task2;

public class Main {

    public static void main(String[] args) {
        int[] numbers = new int[]{5, 6, 3, 2, 5, 1, 4, 9};
        quicksort(numbers);
        printArray(numbers);
    }

    private static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = array[end];
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] <= pivot) {
                swap(array, i, counter);
                counter++;
            }
        }
        swap(array, counter, end);
        quicksort(array, begin, counter - 1);
        quicksort(array, counter + 1, end);
    }

    private static void swap(int[] array, int from, int to) {
        int tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }

    private static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}