package datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationP {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        String s;

        public List<List<Integer>> combine(int n, int k) {

            Integer arr[] = new Integer[n];
            if (n <= 0 || k <= 0) {
                return result;
            }

            for (int i = 1; i <= n; i++) {
                arr[i - 1] = i;
            }
            if (n == k) {
                result.add(Arrays.asList(arr));
                return result;
            }
            int startIndex = 0;
            findCombinations(arr, startIndex,  k, new ArrayList<Integer>());
            return result;
        }

        public void findCombinations(Integer arr[], int startIndex, int r, List<Integer> temp) {

            if (r == 1) {

                for (int i = startIndex; i < arr.length; i++) {
                    List<Integer> finalList = new ArrayList<Integer>();
                    finalList.addAll(temp);
                    finalList.add(arr[i]);
                    result.add(finalList);
                    String str = "";
                    str.length();
                   List<List<Integer>>sdf = new ArrayList<>();


                }
                return;
            }
            //i = 0, i = 1, i = 2
            //1 2 3 4 ,  1(2) 1 (3) 1(4) 2(3) 2(4) 3(4)

            System.out.println("start" + startIndex);
            System.out.println("r" + r);
            for (int i = startIndex; i < arr.length && r >= 1; i++) {
                temp.add(arr[i]);
                startIndex++;
                findCombinations(arr, startIndex, r - 1, temp);

            }

        }
}
