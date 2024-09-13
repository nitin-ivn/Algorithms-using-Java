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
