package datastructures.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFSGraph{
    int[][] a = new int[][]{};
    // Function print matrix in spiral form
    static void spiralPrint(int botRow, int rightCos, int a[][])
    {
        int i, topRow = 0, leftCol = 0;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */
        System.out.println(a[0][0]);
        Map<Integer, List<Integer>>  x = new HashMap<>();
        x.computeIfAbsent(1, k -> new ArrayList<>()).add(2);


        while (topRow < botRow && leftCol < rightCos) {
            // Print the first row from the remaining rows
            for (i = leftCol; i < rightCos; ++i) {
                System.out.print(a[topRow][i] + " ");
            }
            topRow++;

            // Print the last column from the remaining columns
            for (i = topRow; i < botRow; ++i) {
                System.out.print(a[i][rightCos - 1] + " ");
            }
            rightCos--;

            // Print the last row from the remaining rows */
            if (topRow < botRow) {
                for (i = rightCos - 1; i >= leftCol; --i) {
                    System.out.print(a[botRow - 1][i] + " ");
                }
                botRow--;
            }

            // Print the first column from the remaining columns */
            if (leftCol < rightCos) {
                for (i = botRow - 1; i >= topRow; --i) {
                    System.out.print(a[i][leftCol] + " ");
                }
                leftCol++;
            }
        }
    }

    // driver program
    public static void main(String[] args)
    {
        int R = 3;
        int C = 3;
        int a[][] = {
                { 1, 2, 3},
                { 7, 8, 9 },
                { 13, 14, 15 } };
        spiralPrint(R, C, a);
    }
}