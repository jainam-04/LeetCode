import java.util.Arrays;

public class FirstAndLastPositionOfElement {
    public static int[] searchRange(int[] nums, int target){
        int start = search(nums, target, true);
        int end = search(nums, target, false);
        return new int[]{start, end};
    }

    public static int search(int[] nums, int target, boolean findFirstOccurrence){
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target < nums[mid]){
                end = mid - 1;
            }
            else if(target > nums[mid]){
                start = mid + 1;
            }
            else{
                ans = mid;
                if(findFirstOccurrence){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 7, 7, 7, 8, 8, 10};
        int target = 7;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
