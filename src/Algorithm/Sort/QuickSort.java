package Algorithm.Sort;


import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = new int[]{3,6,1,37,7,8};
        quickSort(array,0,array.length-1);

        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int start, int end) {

        int part = partition(array, start, end);

        if (start < part - 1) {
            quickSort(array, start, part - 1);
        }
        if (part < end) {
            quickSort(array, part, end);
        }

    }

    public static int partition(int[] array, int start, int end) {

        int pivot = array[(start + end) / 2];

        while (start <= end) {
            while (pivot > array[start]) start++;
            while (pivot < array[end]) end--;

            if (start <= end) {
                swap(array, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    public static void swap(int[] array, int a, int b) {

        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

