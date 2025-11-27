import java.util.Arrays;

public class MaxSubArrayLengthDivByK {
    public static void main(String[] args) {
        int[] nums = {-5, 1, 2, -3, 4};
        int k = 2;
        long result = maxSubArraySum(nums, k);
        System.out.println(result);
    }

    public static long maxSubArraySum(int[] nums, int k){
        long prefixSum = 0;
        long subMax = Long.MIN_VALUE;
        long[] minSoFar = new long[k];
        Arrays.fill(minSoFar, Long.MAX_VALUE / 2);
        minSoFar[(k - 1) % k] = 0;
        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            subMax = Math.max(subMax, prefixSum - minSoFar[i % k]);
            minSoFar[i % k] = Math.min(minSoFar[i % k], prefixSum);
        }
        return subMax;
    }
}
