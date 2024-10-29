//Given an array arr[], the task is to find the subarray that has the maximum sum and return its sum.
//The idea of Kadane’s algorithm is to traverse over the array from left to right and for each element,
// find the maximum sum among all subarrays ending at that element. The result will be the maximum of all these values.
//
//To calculate the maximum sum of subarray ending at current element, say maxEnding,
// we can use the maximum sum ending at the previous element. So for any element, we have two choices:
//
//Choice 1: Extend the maximum sum subarray ending at the previous element by adding the current element to it.
// If the maximum subarray sum ending at the previous index is positive, then it is always better to extend the subarray.
//Choice 2: Start a new subarray starting from the current element.
// If the maximum subarray sum ending at the previous index is negative,
// it is always better to start a new subarray from the current element.
//This means that maxEnding at index i = max(maxEnding at index (i – 1) + arr[i], arr[i]) and the
// maximum value of maxEnding at any index will be our answer.

public class maximumSubArrayUsingKadanesAlgorithm {
    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubArraySum(arr));
    }

    private static int maxSubArraySum(int[] arr) {
        int result = 0;
        int maxIndex = 0;

        for(int i=0;i<arr.length;i++){
            maxIndex = Math.max(maxIndex + arr[i],arr[i]);
            result = Math.max(maxIndex,result);
        }

        return result;
    }
}
