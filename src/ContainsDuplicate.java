import java.util.Arrays;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums){
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] == nums[i]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }
}
