import java.util.Arrays;

public class ValidTriangleNumber {
    public static int triangleNumber(int[] nums){
        Arrays.sort(nums);
        int count = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            int start = 0;
            int end = i - 1;
            while(start < end){
                int sum = nums[start] + nums[end];
                if(sum > nums[i]){
                    count = count + (end - start);
                    end--;
                }
                else {
                    start++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4};
        System.out.println(triangleNumber(nums));
    }
}
