import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int[] nums = new int[m + n];
        if (m >= 0) {
            System.arraycopy(nums1, 0, nums, 0, m);
        }
        for(int j = 0, i = m; j < n; j++){
            nums[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int m = nums1.length;
        int[] nums2 = {2, 5, 6};
        int n = nums2.length;
        merge(nums1, m, nums2, n);
    }
}
