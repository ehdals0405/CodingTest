package Algorithm.Sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        int[] array = new int[]{3,2,1,5};
        bubbleSort(array);

        System.out.println(Arrays.toString(array));
    }
    public static void bubbleSort(int[] array){

        int size = array.length;

        for (int i = 1; i < size; i++) {

            for (int j = 0; j < size - i; j++) {

                if(array[j+1] < array[j] ){
                    swap(array,j,j+1);
                }
            }
        }
    }
    private static void swap(int[] array, int a, int b){

        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;

    }
}
