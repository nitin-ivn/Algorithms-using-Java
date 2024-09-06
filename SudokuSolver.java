public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if(Sudoku(board)){
            display(board);
        }else{
            System.out.println("Cannot be solved");
        }
    }

    private static boolean Sudoku(int[][] board){
        int row = -1;
        int col = -1;

        boolean leftEmpty = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    leftEmpty = false;
                }
            }

            if(!leftEmpty){
                break;
            }
        }

        if(leftEmpty){
            return true;
        }

        for (int i = 1; i <= 9; i++) {
            if(isSafe(board,row,col,i)){
                board[row][col] = i;
                if(Sudoku(board)){
                    return true;
                }else{
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board,int row,int col,int num){
        for(int i=0;i<board.length;i++){
            if(board[row][i] == num){
                return false;
            }
        }

        for(int[] nums : board){
            if(nums[col] == num){
                return false;
            }
        }

        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for(int r = rowStart;r < rowStart + sqrt;r++){
            for(int c = colStart;c < colStart + sqrt;c++){
                if(board[r][c] == num){
                    return false;
                }
            }
        }
    return true;
    }

    private static void display(int[][] board){
        for(int[] nums : board){
            for(int num : nums){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
