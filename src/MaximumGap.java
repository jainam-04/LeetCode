import java.util.Arrays;

public class MaximumGap {
    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1};
        System.out.println(maximumGap(nums));
    }
    public static int maximumGap(int[] nums){
        if(nums.length == 1){
            return 0;
        }
        int maximum_difference = 0;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i - 1] > maximum_difference){
                maximum_difference = nums[i] - nums[i - 1];
            }
        }
        return maximum_difference;
    }
}
