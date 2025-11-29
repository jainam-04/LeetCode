public class MinOpToMakeArrSumDivByK {
    public static void main(String[] args) {
        int[] nums = {3, 2};
        int k = 6;
        int result = minOperations(nums, k);
        System.out.println(result);
    }

    public static int minOperations(int[] nums, int k){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return sum % k;
    }
}
