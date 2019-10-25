package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Partition problem is to determine whether a given set can be partitioned
 * into two subsets such that the sum of elements in both subsets is same.
 * arr[] = {1, 5, 11, 5}
 * Output: true
 * The array can be partitioned as {1,2,  5, 5} and {11}
 */

/**
 * Self
 */
public class PartitionProblem {


    public static void main(String args[]) {

     System.out.println(s);
    }

    static boolean subsetAddition(int sum, List<Integer> subset) {
        System.out.println(sum);
        if (subset.size() == 1) {
            if (subset.get(0) == sum) {
                return true;
            }
        } else {
            for (int i = 0; i < subset.size(); i++) {
                List<Integer> newList = new ArrayList<>(subset);
                int newSum = sum-newList.get(i);
                if(newSum == 0){
                    return true;
                }else if(newSum < 0){
                  newList.remove(newList.get(i));
                  continue;
                }
                newList.remove(newList.get(i));
                boolean is = subsetAddition(newSum, newList);
                if (is) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    static boolean isSubsetSum(int set[], int n, int sum)
    {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        // If last element is greater than sum, then ignore it
        if (set[n-1] > sum)
            return isSubsetSum(set, n-1, sum);

   /* else, check if sum can be obtained by any of the following
      (a) including the last element
      (b) excluding the last element   */
        return isSubsetSum(set, n-1, sum) ||
                isSubsetSum(set, n-1, sum-set[n-1]);
    }
}