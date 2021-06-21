package datastructures.graph;

import jdk.internal.util.xml.impl.Pair;

import java.io.StringBufferInputStream;

public class Pascal {

    public static void main(String[] args){
        int n = 5, k = 3;
        String s ="";
        String a = "abcdefg";
       int index = 'z' - 'A';
       System.out.println(index);
       // System.out.println(b.indexOf(a));
        System.out.printf("Value of C(%d, %d) is %d "
                , n, k, binomialCoeff(n, k));
    }

    static int binomialCoeff(int n, int k)
    {

        int C[] = new int[k + 1];

        // nC0 is 1
        C[0] = 1;

        for (int i = 1; i <= n; i++)
        {
            // Compute next row of pascal
            // triangle using the previous row
            for (int j = Math.min(i, k); j > 0; j--)
                C[j] = C[j] + C[j-1];
        }
        return C[k];
    }
}
