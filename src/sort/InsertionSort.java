package sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertionSort {

    /**
     * 5 6 1 4 2 3
     * 5 6 1 4 2 3
     * 5 6 1 4 2 3
     * 1 5 6 4 2 3
     * 1 4 5 6 2 3
     * 1 2 4 5 6 3
     * 1 2 3 4 5 6
     * @param args
     */
    public static void main(String args[]){
        int arr[] = { 5, 6, 1 ,4, 2, 3};
       // insertionSort(arr);
        List<Integer> list = new ArrayList<>();
        list.add(0,1);
        list.add(1,2);
        list.add(2,3);
        list.add(3,4);
        System.out.println(list.toString());
        for(int i =0; i < 1; i++){
            Integer temp = list.get(list.size()-1 - i);
            list.add(list.size()-1-i,list.get(i));
            list.add(i, temp);
            i++;
        }
       System.out.println(list.toString());

    }
    private static void insertionSort(int[] arr) {
        for(int i=0; i < arr.length; i ++){
            insertIntoCorrectPlace(arr, i);
        }
    }
    private static void insertIntoCorrectPlace(int[] arr, int i) {
        for( int j = 0; j < i ; j ++){
            if(arr[i]< arr[j]){
                int temp = arr[j];
                arr [j] = arr[i];
                arr[i]= temp;
            }
        }
        System.out.println("Pass ");
        System.out.println(Arrays.toString(arr));
    }


}
