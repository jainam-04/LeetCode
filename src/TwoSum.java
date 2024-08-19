import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int current;
        for(int i = 0; i < nums.length; i++){
            current = target - nums[i];
            if(map.containsKey(current)){
                return new int[]{map.get(current), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
