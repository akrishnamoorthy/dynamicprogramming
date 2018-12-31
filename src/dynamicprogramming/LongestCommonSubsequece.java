package dynamicprogramming;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * By Self
 */
public class LongestCommonSubsequece {

    public static void main(String args[]){
        String firstString = "ABCDETYZUGG" ;
        String secondString = "TYZUPMAEBDFGG";
        /**
         *    A B C D E T Y Z U G G A
         * T            x
         * Y              x
         * Z               x
         * U                 x
         * P
         * M
         * A x                       x
         * E          x
         * B   x
         * D        x
         * F
         * G                    x
         * G                      x
         *
         */

        int max =identifyLongestCommonSubsequence(firstString,secondString);
        System.out.println("Longest seq length " + max);
    }

    private static int identifyLongestCommonSubsequence(String firstString, String secondString) {
        Map<String,Integer> seqWithLastIndex = new HashMap<>();
        for(int index = 0 ; index < firstString.length() ; index ++ ){
            char currentChar = firstString.charAt(index);
          if(secondString.indexOf(currentChar) != -1){
              System.out.println(seqWithLastIndex.toString());
             updateMap(seqWithLastIndex,currentChar,secondString.indexOf(currentChar));
          }
        }
        int max = 0;
        for(String longestSeq : seqWithLastIndex.keySet()){
           if(longestSeq.length() > max) {
               max = longestSeq.length();
           }
        }
        return max;
    }

    private static void updateMap( Map<String,Integer> seqWithLastIndex,char currentChar,int secondStringIndex ){
        seqWithLastIndex.put(""+currentChar,secondStringIndex);
        Map<String,Integer> clonedmap = new HashMap<>();
        clonedmap.putAll(seqWithLastIndex);
        Iterator it  = clonedmap.keySet().iterator();
        while(it.hasNext()){
            String stringVal  = (String) it.next();
            if(secondStringIndex > clonedmap.get(stringVal) ){
                seqWithLastIndex.put(stringVal+currentChar,secondStringIndex);

            }
        }
    }


}
