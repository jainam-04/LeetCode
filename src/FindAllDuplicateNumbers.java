import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicateNumbers {
    public static List<Integer> findDuplicates(int[] nums){
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
        for(int index = 0; index < nums.length; index++){
            if(nums[index] != index + 1){
                list.add(nums[index]);
            }
        }
        return list;
    }

    public static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }
}
