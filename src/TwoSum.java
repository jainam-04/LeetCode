import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        if(nums.length == 2){
            if(nums[0] + nums[1] == target){
                return new int[]{0, 1};
            }
            else{
                return new int[]{-1, -1};
            }
        }
        else{
            for(int i = 0; i < nums.length; i++){
                for(int j = i + 1; j < nums.length; j++){
                    if(nums[i] + nums[j] == target){
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
