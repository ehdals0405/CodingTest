package Algorithm.Sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {


        int[] array = new int[]{3,2,1,5,0};
        SelectSort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void SelectSort(int[] array){

        int size = array.length;

        for (int i = 0; i < size -1; i++) {
            int minIndex = i;

            for (int j = i; j < size; j++) {

                if(array[minIndex] > array[j]){
                    minIndex = j;
                }
            }
            swap(array,i,minIndex);
        }

    }
    private static void swap(int[] array, int a, int b){

        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;

    }
}
