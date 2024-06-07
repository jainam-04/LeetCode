import java.util.Arrays;

public class TwoSum2 {
    public static int[] twoSum(int[] nums, int target){
        if(nums.length == 2){
            if(nums[0] + nums[1] == target){
                return new int[]{1, 2};
            }
            else{
                return new int[]{-1, -1};
            }
        }
        else{
            for(int i = 0; i < nums.length; i++){
                for(int j = i + 1; j < nums.length; j++){
                    if(nums[i] + nums[j] == target){
                        return new int[]{i + 1, j + 1};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
