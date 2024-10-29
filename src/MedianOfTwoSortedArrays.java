public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(medianOfTwoSortedArrays(nums1, nums2));
    }

    public static double medianOfTwoSortedArrays(int[] nums1, int[] nums2){
        int[] merged = merge(nums1, nums2);
        int start = 0;
        int end = merged.length - 1;
        int mid = start + (end - start) / 2;
        if(merged.length % 2 == 0){
            return (double) (merged[mid] + merged[mid + 1]) / 2;
        }
        else{
            return (merged[mid]);
        }
    }

    public static int[] merge(int[] nums1, int[] nums2){
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while((i < nums1.length) && (j < nums2.length)){
            if(nums1[i] < nums2[j]){
                merged[k] = nums1[i];
                i++;
            }
            else{
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i < nums1.length){
            merged[k] = nums1[i];
            i++;
            k++;
        }
        while(j < nums2.length){
            merged[k] = nums2[j];
            j++;
            k++;
        }
        return merged;
    }
}
