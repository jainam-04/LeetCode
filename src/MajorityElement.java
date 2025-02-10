public class MajorityElement {
    public static int majorityElement(int[] nums){
        int majority_index = 0;
        int count = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[majority_index] == nums[i]){
                count++;
            }
            else{
                count--;
            }
            if(count == 0){
                majority_index = i;
                count = 1;
            }
        }
        count = 0;
        for (int num : nums) {
            if (nums[majority_index] == num) {
                count++;
            }
        }
        return nums[majority_index];
    }

    public static void main(String[] args) {
        int[] nums = {8, 5, 8, 3, 8, 8, 8};
        System.out.println(majorityElement(nums));
    }
}
