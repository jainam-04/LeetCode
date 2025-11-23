public class GreatestSumDivisibleByThree {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4};
        int result = maxSumDivThree(nums);
        System.out.println(result);
    }

    public static int maxSumDivThree(int[] nums){
        int sum = 0;
        int mod1a = Integer.MAX_VALUE;
        int mod1b = Integer.MAX_VALUE;
        int mod2a = Integer.MAX_VALUE;
        int mod2b = Integer.MAX_VALUE;
        for(int num : nums){
            sum += num;
            int rem = num % 3;
            if(rem == 1){
                if(num < mod1a){
                    mod1b = mod1a;
                    mod1a = num;
                }
                else if(num < mod1b){
                    mod1b = num;
                }
            }
            else if(rem == 2){
                if(num < mod2a){
                    mod2b = mod2a;
                    mod2a = num;
                }
                else if(num < mod2b){
                    mod2b = num;
                }
            }
        }
        int rem = sum % 3;
        if(rem == 0){
            return sum;
        }
        int remove;
        if(rem == 1){
            remove = Math.min(mod1a, (mod2a == Integer.MAX_VALUE || mod2b == Integer.MAX_VALUE) ? Integer.MAX_VALUE : mod2a + mod2b);
        }
        else{
            remove = Math.min(mod2a, (mod1a == Integer.MAX_VALUE || mod1b == Integer.MAX_VALUE) ? Integer.MAX_VALUE : mod1a + mod1b);
        }
        return remove == Integer.MAX_VALUE ? 0 : sum - remove;
    }
}
