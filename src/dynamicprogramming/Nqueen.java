package dynamicprogramming;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
public class Nqueen {

        List<List<String>> result = new ArrayList<>();
        List<String> x = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            int[][] board = new int[n][n];
            boolean found =  solveNQueensUtil(board, n , 0 );
            return result;
        }

    public boolean solveNQueensUtil(int[][] board, int n, int row) {

        boolean solved = false;

        if(row   == n ){
            System.out.println("jhwer");
            List<String> rx = new ArrayList<String>();
            for(int i = 0; i < n ; i ++){
                String s = "";

                for(int j =0; j < n; j++){
                    System.out.print(board[i][j]);
                    s = board[i][j] == 0 ? s+"." : s+"Q";
                }
                rx.add(s);
                System.out.println(" ");
            }
            result.add(rx);
            return true;
        }


        for(int i = 0; i < n ;i ++){

            if(isSafe(board, row, i, n)){
                board[row][i] = 1;
                solved =  solveNQueensUtil(board, n , row + 1);
                board[row][i] = 0;

            }

        }
        return false;
    }

    boolean isSafe(int board[][], int row, int col, int N)
    {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }


    public static void main(String args[]) throws UnknownHostException {
        System.out.println(InetAddress.getByName("performancemanager4.successfactors.com"));
            Nqueen queen = new Nqueen();
            queen.solveNQueens(4);
        }

}
