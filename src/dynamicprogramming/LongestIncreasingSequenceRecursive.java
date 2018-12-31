package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
/**
 * By Self - TB completed
 */
public class LongestIncreasingSequenceRecursive {
    /**
     *WRONG
     * 1 3 6  9 5 7 10
     * -- 1 3  5 7 10
     * LIS(1,n) =  1 + LIS(1,j) where arr[n] > arr[j]
     * @param args
     */
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);//0
        list.add(3);//1
        list.add(7);//2
        list.add(2);//3
        list.add(0);//4
        list.add(9);//5
//3,
        int val = longSubSequence(list,0);
        System.out.println(val);
    }

    private static int longSubSequence(List<Integer> list,int max) {
        int lastIndex = list.size()-1;
        int currentLis = 0;
        if(list.size() == 1){
            return 1;
        } else {
            int x = lastIndex ;
            while ( x >=0 ){
                if(list.get(lastIndex)  > list.get(x)){
                   currentLis = 1 +  longSubSequence(list.subList(0, x + 1),max);
                   return Math.max(max, currentLis) ;
                } else {
                    x--;
                }

            }
            return 1;
        }
    }

}
