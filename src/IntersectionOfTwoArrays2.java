import java.util.Arrays;

public class IntersectionOfTwoArrays2 {
    public static int[] intersection(int[] nums1, int[] nums2){
        int l1 = nums1.length;
        int l2 = nums2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while((i < l1) && (j < l2)){
            if(nums1[i] < nums2[j]){
                i++;
            }
            else if(nums1[i] > nums2[j]){
                j++;
            }
            else{
                nums1[k] = nums1[i];
                k++;
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
