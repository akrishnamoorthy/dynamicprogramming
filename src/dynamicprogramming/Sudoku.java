package dynamicprogramming;

public class Sudoku {

        public void solveSudoku(char[][] board) {
            solveSudoku(board, 0, 0 );
            int start = 0 ; int end = 5;
            int mid = ( start + end )/2;
        }

        boolean solveSudoku(char[][] board, int i, int j ) {

            if((i == 9 ) && (j ==9)){
                return true;
            }
            while(i < 9 &&  j < 9 ){
                if(board[i][j] != '.'){
                    if(j == 8){
                        i++;
                        j =0;
                    } else {
                        j++;
                    }
                    continue;
                }

                for(char val = '1'; val<= '9' ; val++){
                    if(isValid(board, i,j, val)){
                        board[i][j] =  val;
                        if(j == 8){
                            i = i+1;
                            j=0;
                        } else {
                            j= j+1;
                        }
                        boolean solve =  solveSudoku(board, i, j );
                        if(!solve){
                            board[i][j] = '.';
                        }
                    }
                }
                return false;
            }
            return false;
        }

        void  increment(int i, int j){
            if(j == 8){
                i++;
                j =0;
            } else {
                j++;
            }
        }

        public  boolean isValid(char[][] board, int row, int col, char c){
            // check row
            for(int i = 0; i < board[0].length; i++){
                if(board[row][i] != '.' && board[row][i] == c)
                    return false;
            }
            // check col
            for(int i = 0; i < board.length; i++){
                if(board[i][col] != '.' && board[i][col] == c)
                    return false;
            }
            // check sub-box
            int rowBegin = row / 3 * 3;
            int colBegin = col / 3 * 3;
            for(int i = rowBegin; i < rowBegin + 3; i++){
                for(int j = colBegin; j < colBegin + 3; j++){
                    if(board[i][j] != '.' && board[i][j] == c)
                        return false;
                }
            }

            return true;
        }


    public  static  void main(String args[]){
        char[][] arr = new char[][] { new char[] {'5','3','.','.','7','.','.','.','.'},
                new char[] {'6','.','.','1','9','5','.','.','.'},new char[]{'.','9','8','.','.','.','.','6','.'},
                new char[]{'8','.','.','.','6','.','.','.','3'},new char[]{'4','.','.','8','.','3','.','.','1'},
                new char[]{'7','.','.','.','2','.','.','.','6'},new char[]{'.','6','.','.','.','.','2','8','.'},
                new char[]{'.','.','.','4','1','9','.','.','5'},new char[]{'.','.','.','.','8','.','.','7','9'}};
        
        Sudoku s = new Sudoku();
        s.solveSudoku(arr);
    }

}
