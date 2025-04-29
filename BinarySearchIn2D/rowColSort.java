package BinarySearchIn2D;

public class rowColSort {
    public static void main(String[] args) {
        int[][] arr = {
                {10,20,30,40},
                {15,25,35,45},
                {28,29,37,49},
                {33,34,38,50}
        };

        search(arr,37);
    }

    public static void search(int[][] matrix, int target){
        int r = 0;
        int c = matrix.length - 1;

        while(r<matrix.length && c >= 0){
            if(matrix[r][c] == target){
                System.out.println("Found: "+r+" " +c);
                return;
            }
            if(matrix[r][c] > target){
                c--;
            }else {
                r++;
            }
        }
        System.out.println("not found");
    }
}
