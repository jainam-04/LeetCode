public class SingleNumber {
    public static int singleNumber(int[] nums){
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 4};
        System.out.println(singleNumber(nums));
    }
}
