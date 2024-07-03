public class FindAllDuplicateNumbers {
    public static int findDuplicate(int[] nums){
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            if((nums[i] < nums.length) && (nums[i] != nums[correctIndex])){
                swap(nums, i, correctIndex);
            }
            else{
                i++;
            }
        }
        for(int index = 0; index < nums.length; index++){
            if(nums[index] != index + 1){
                return nums[index];
            }
        }
        return nums.length;
    }

    public static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 3, 3};
        System.out.println(findDuplicate(nums));
    }
}
