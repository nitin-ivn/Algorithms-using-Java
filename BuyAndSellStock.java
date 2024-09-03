import java.util.Arrays;

import static java.lang.Integer.MIN_VALUE;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        System.out.println(Arrays.toString(find_max_array(arr,0,arr.length-1)));
    }

    public static int[] find_max_array(int[] arr,int low,int high){
        int mid;
        int[] leftarr,middlearr,rightarr;
        int[] temparr = new int[3];
        if(high == low){
            temparr[0] = low;
            temparr[1] = high;
            temparr[2] = arr[low];
            return temparr;
        }else{
            mid = (low+high)/2;
            leftarr = find_max_array(arr,low,mid);
            middlearr = find_max_middle_array(arr,low,mid,high);
            rightarr = find_max_array(arr,mid+1,high);

            if(leftarr[2] >= rightarr[2] && leftarr[2] >= middlearr[2]){
                return leftarr;
            }else if(rightarr[2] >= middlearr[2]){
                return rightarr;
            }else{
                return middlearr;
            }
        }

    }

    public static int[] find_max_middle_array(int[] arr,int low,int mid,int high){
        int[] temparr = new int[3];
        int sum = 0,maxleft=0,maxright=0;
        int leftsum = MIN_VALUE;
        for(int i=mid;i>=low;i--){
            sum += arr[i];
            if(sum > leftsum){
                leftsum = sum;
                maxleft = i;
            }
        }

        int rightsum = MIN_VALUE;
        sum=0;
        for(int j = mid+1; j <high; j++){
            sum += arr[j];
            if(sum > rightsum){
                rightsum = sum;
                maxright = j;
            }
        }

        temparr[0] = maxleft;
        temparr[1] = maxright;
        temparr[2] = leftsum+rightsum;
        return temparr;
    }
}
