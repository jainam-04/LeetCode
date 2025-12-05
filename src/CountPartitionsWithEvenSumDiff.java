public class CountPartitionsWithEvenSumDiff {
    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8};
        int result = countPartitions(nums);
        System.out.println(result);
    }

    public static int countPartitions(int[] nums){
        int oddCount = 0;
        for(int num : nums){
            if(num % 2 != 0){
                oddCount += num;
            }
        }
        if(oddCount % 2 != 0){
            return 0;
        }
        return nums.length - 1;
    }
}
