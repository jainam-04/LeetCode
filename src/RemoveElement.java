import java.util.Arrays;

public class RemoveElement {
    public static int removeElement(int[] nums, int val){
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            if(nums[start] == val){
                nums[start] = '_';
            }
            if(nums[end] == val){
                nums[end] = '_';
            }
            start++;
            end--;
        }
        int count = 0;
        for (int num : nums) {
            if (num == '_') {
                count++;
            }
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 2};
        int val = 3;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }
}
