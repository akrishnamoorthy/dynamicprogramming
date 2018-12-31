package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 */
public class RodCuttingMaximumPrice {
    static Map<Integer,Double> pricePerLength = new HashMap<>();

    public static void main(String args[]){
        pricePerLength.put(1,1.0);
        pricePerLength.put(2,5.0);
        pricePerLength.put(3,8.0);
        pricePerLength.put(4,9.0);
        pricePerLength.put(5,10.0);
        pricePerLength.put(6,17.0);
        pricePerLength.put(7,17.0);
        pricePerLength.put(8,20.0);

        System.out.println(findBestPrice(8));
    }

    private static double findBestPrice(int length) {
        double maxPrice = pricePerLength.get(length) != null ? pricePerLength.get(length) : 0.0;
       for(int i =1 ; i < length ; i ++){
           double currentPrice = pricePerLength.get(i) + findBestPrice(length-i);
           maxPrice = currentPrice > maxPrice ? currentPrice : maxPrice;
       }
      return maxPrice;
    }


}
