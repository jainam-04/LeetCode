public class MakeAllElementsDivisibleByThree {
    public static void main(String[] args) {
        int[] nums = {3, 6, 9};
        int result = minimumOperations(nums);
        System.out.println(result);
    }

    public static int minimumOperations(int[] nums){
        int count = 0;
        for(int num : nums){
            if(!(num % 3 == 0)){
                count++;
            }
        }
        return count;
    }
}
