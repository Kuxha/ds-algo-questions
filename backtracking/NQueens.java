package backtracking;

public class NQueens {



    // Place a queen in every row of the board

    public static void printBoard(char board[][]){

        System.out.println("----Chess board of the Queen---");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    public static boolean isSafe(char board[][],int row,int col){


        // First check up

       // same column - row keeps decreasing
        for (int i = row-1; i >=0; i--) {

            if(board[i][col] == 'Q'){
                  return false;
            }         
        }


        // then check diagonally left

        for (int i = row-1,j = col -1; i >=0 && j>=0; i--,j--) {
            if(board[i][j] == 'Q'){
                 return false;
            }  

        }


        // then check right dialoganlly
        for (int i = row-1,j = col +1; i >=0 && j<board.length; i--,j++) {
            if(board[i][j] == 'Q'){
                return false;
            }  

        }

        return true;

    }
    public static void NqueenPlace(char [][]board,int row){


        if(row == board.length){
            printBoard(board);
            return;
        }

        // Go through each row
        // Once you place your queen in the correct position - Call NQueen on the next row
        for (int i = 0; i < board.length; i++) {

            if(isSafe(board, row, i)){
                board[row][i] = 'Q';
                NqueenPlace(board, row+1);
                board[row][i] = 'x';
            }
              

            
          
        }

    }

    public static void main(String[] args) {
        
        int n = 4;

        char [][] board = new char[n][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                    board[i][j] = 'x';
            }
        }
        
        NqueenPlace(board,0);
        
    }
    
}
