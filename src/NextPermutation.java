import java.util.Arrays;

public class NextPermutation {
    public static void nextPermutation(int[] nums){
        int index = -1;
        int n = nums.length;
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            reverse(nums, 0, n - 1);
        }
        else{
            for(int i = n - 1; i > index; i--){
                if(nums[i] > nums[index]){
                    swap(nums, i, index);
                    break;
                }
            }
            reverse(nums, index + 1, n - 1);
        }
    }

    public static void reverse(int[] nums, int start, int end){
        int mid = start + (end - start) / 2;
        for(int i = start; i <= mid; i++){
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
