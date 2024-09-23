public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,11,-8,4};
        int[] arr2 = new int[]{1,2,3,4,5};
        int k = 3; //size of subarray
        System.out.println(silidingwindowforMaxSubArray(arr,k));
        System.out.println(minSubArrayLen(11,arr2));
    }

    private static int silidingwindowforMaxSubArray(int[] arr, int k) {
        int maxElement = 0;

        if (arr.length <= k) {
            System.out.println("Invalid");
            return -1;
        }

        for(int i=0;i<k;i++){
            maxElement += arr[i];
        }

        int currentSum = maxElement;
        for (int i = k; i < arr.length; i++) {
            currentSum += arr[i] - arr[i-k];
            maxElement = Math.max(currentSum,maxElement);
        }

        return maxElement;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int currentSum = 0, minLength = nums.length+1;

        int start = 0,end = 0;
        while(end < nums.length){

            while(currentSum < target && end < nums.length){
                currentSum += nums[end++];
            }

            while(currentSum >= target && start < nums.length){
                if(end - start < minLength){
                    minLength = end-start;
                }

                currentSum -= nums[start++];
            }
        }

        if(minLength == nums.length + 1){
            return 0;
        }else {
            return minLength;
        }
    }
}
