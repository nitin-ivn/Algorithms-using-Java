import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{45,2,8,63,105,1,23};
        mergeSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr){
        MergeRecursive(arr,0,arr.length-1);
    }

    public static void MergeRecursive(int[] arr,int p,int q){
        if(p<q){
            int r = ((p+q)/2);
            MergeRecursive(arr,p,r);
            MergeRecursive(arr,r+1,q);
            Merge(arr,p,r,q);
        }
    }

    public static void Merge(int[] arr,int p,int q,int r){
        int n1 = q-p+1;
        int n2 = r-q;

        int[] LeftArr = new int[n1+1];
        int[] RightArr = new int[n2+1];

        for(int i=0;i<n1;i++){
            LeftArr[i] = arr[p+i];
        }

        for(int j = 0; j <n2; j++){
            RightArr[j] = arr[q+1+j];
        }

        LeftArr[n1] = Integer.MAX_VALUE;
        RightArr[n2] = Integer.MAX_VALUE;

        int x = 0;
        int y = 0;
        for(int k=p;k<=r;k++){
            if(LeftArr[x] <= RightArr[y]){
                arr[k] = LeftArr[x];
                x++;
            }else{
                arr[k] = RightArr[y];
                y++;
            }
        }
    }
}
