//this method uses backtracking and checking the positions of other knights. The isSafe method is for checking the
//positions of other knights

import java.util.Scanner;

public class nKnights {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of board: ");
        n = sc.nextInt();
        boolean[][] board = new boolean[n][n];
        placeKnights(board,0,0,n);
    }

    private static void placeKnights(boolean[][] board, int row, int col, int target){
        if(target == 0){
            display(board);
            System.out.println();
            return;
        }

        if(row == board.length-1 && col == board.length){
            return;
        }

        if(col == board.length){
            placeKnights(board,row+1,0,target);
            return;
        }

        if(isSafe(board,row,col)){
            board[row][col] = true;
            placeKnights(board,row,col+1,target-1);
            board[row][col] = false;
        }

        placeKnights(board,row,col+1,target);
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if(isValid(board,row-2,col+1)){
            if(board[row-2][col+1]){
                return false;
            }
        }

        if(isValid(board,row-2,col-1)){
            if(board[row-2][col-1]){
                return false;
            }
        }

        if(isValid(board,row-1,col+2)){
            if(board[row][col]){
                return false;
            }
        }

        if(isValid(board,row-1,col-2)){
            if(board[row][col]){
                return false;
            }
        }

        return true;
    }

    private static boolean isValid(boolean[][] board,int row,int col){
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row : board){
            for (boolean element: row){
                if(element){
                    System.out.print("K ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}