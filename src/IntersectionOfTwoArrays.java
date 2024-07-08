import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2){
        HashSet<Integer> set = new HashSet<>();
        for (int j : nums1) {
            for (int k : nums2) {
                if (j == k) {
                    set.add(j);
                    break;
                }
            }
        }
        int[] ans = new int[set.size()];
        int i = 0;
        for(int num : set){
            ans[i] = num;
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
