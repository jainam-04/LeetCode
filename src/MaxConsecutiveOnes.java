public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1, 0, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums){
        int current_sum = 0;
        int max_sum = Integer.MIN_VALUE;
        for (int num : nums) {
            current_sum += num;
            if (current_sum > max_sum) {
                max_sum = current_sum;
            }
            if (num == 0) {
                current_sum = 0;
            }
        }
        return max_sum;
    }
}
