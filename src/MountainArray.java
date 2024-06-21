public class MountainArray {
    public static int findInMountainArray(int[] nums, int target){
        int peak = findPeakElement(nums);
        int firstTry = orderAgnosticBinarySearch(nums, target, 0, peak);
        if(firstTry != -1){
            return firstTry;
        }
        return orderAgnosticBinarySearch(nums, target, peak + 1, nums.length - 1);
    }

    public static int findPeakElement(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid + 1]){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return start;
    }

    public static int orderAgnosticBinarySearch(int[] nums, int target, int start, int end){
        boolean isAsc = nums[end] > nums[start];
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == nums[mid]){
                return mid;
            }
            if(isAsc){
                if(target < nums[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                if(target > nums[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 2, 1};
        int target = 3;
        System.out.println(findInMountainArray(nums, target));
    }
}
