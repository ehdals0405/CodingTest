package Algorithm.Sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {

        int[] array = new int[]{3,2,1,5};
        insertSort(array);

        System.out.println(Arrays.toString(array));
    }
    public static void insertSort(int[] array){

        int size = array.length;

        for (int i = 1; i < size; i++) {

            int current = array[i];
            int j = i - 1;
                while (j >= 0 && current < array[j] ){
                    array[j+1] = array[j];
                    j--;
                }

                array[j+1] = current;
            }
    }
}
