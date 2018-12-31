package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by I073413 on 3/2/2018.
 */

/**
 * Given a list of numbers ,identify longest increasing sequence
 *
 * 1 4 9  2  44 17 13 15 90
 *
 * 1 4 9 13 15 90 ( 6)
 *
 * 10 22 9 33  21 50 41 60 80
 * 10 22 33 50  60 80 ( 6)
 *
 * 1 2  5 4 9 10 8 7 11 6  --6
 *
 * LIS(STR(x,n) ) = 1 + LIS(STR(x+1,n) if STR(x)< STR(x+1)
 *
 */
/**
 * By Self
 */
public class LongestIncreasingSequence {

    private static Map<Integer, Integer> resultset = new HashMap<>();

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(4);
        list.add(9);
        list.add(10);
        list.add(8);
        list.add(10);
        list.add(11);
        list.add(6);
        resultset = new HashMap<>();
        resultset.put(0, 1);
        returnLIS(list);
        ;
    }

    private static void returnLIS(ArrayList list) {
        resultset.put(0, 1);
        for (int index = 1; index < list.size(); index++) {
            if ((Integer) list.get(index) > (Integer) list.get(index - 1)) {
                resultset.put(index, (1 + resultset.get(index - 1)));
            } else {
                int max = 0;
                for (int indexy = index; indexy >= 0; indexy--) {
                    if ((Integer) list.get(index) > (Integer) list.get(indexy)) {
                        if (resultset.get(indexy) > max) {
                            max = resultset.get(indexy);
                        }
                    }
                }
                resultset.put(index, max + 1);
            }
        }
        for(Integer integerVal : resultset.keySet()){
            System.out.println(list.get(integerVal) +  " : " + resultset.get(integerVal));
        }

    }
}
