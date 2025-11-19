public class MultiplyFoundValuesByTwo {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9};
        int original = 2;
        int result = findFinalValue(nums, original);
        System.out.println(result);
    }

    public static int findFinalValue(int[] nums, int original){
        for(int i = 0; i < nums.length; i++){
            for (int num : nums) {
                if (num == original) {
                    original = original * 2;
                }
            }
        }
        return original;
    }
}
