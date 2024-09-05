import java.util.Scanner;

public class nQueens {
    public static void main(String[] args) {
        int n =4;
        boolean[][] board = new boolean[n][n];
        System.out.println(placeQueens(board,0));
    }

    private static int placeQueens(boolean[][] board, int row) {
        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;
        for(int col = 0;col < board[0].length;col++){
            if(CanPutQueen(board,row,col)){
                board[row][col] = true;
                count += placeQueens(board,row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean CanPutQueen(boolean[][] board, int row, int col) {
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }

        int maxLeft = Math.min(row,col);
        for(int i=1;i<=maxLeft;i++){
            if(board[row-i][col-i]){
                return false;
            }
        }

        int maxRight = Math.min(row,board[0].length-col-1);
        for(int i=1;i<=maxRight;i++){
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row : board){
            for (boolean element: row){
                if(element){
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
