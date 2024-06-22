import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7,43,65,2,1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void insertionSort(int[] arr){
        int n = arr.length,i=0;
        int key;
        for(int j=1;j<n;j++){
            key = arr[j];
            i = j;
            while(i > 0 && arr[i-1] > key){
                arr[i] = arr[i-1];
                i = i-1;
            }
            arr[i] = key;
        }
    }
}
