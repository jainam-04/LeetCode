public class MakeAllElementsToOne {
    public static void main(String[] args) {
        int[] nums = {2, 10, 6, 14};
        int result = minOperations(nums);
        System.out.println(result);
    }

    public static int minOperations(int[] nums){
        int n = nums.length;
        int countOne = 0;
        int g = 0;
        for(int num : nums){
            if(num == 1){
                countOne++;
            }
            g = gcd(g, num);
        }
        if(countOne > 0){
            return n - countOne;
        }
        if(g > 1){
            return -1;
        }
        int minLength = n;
        for(int i = 0; i < n; i++){
            int currentGcd = 0;
            for(int j = i; j < n; j++){
                currentGcd = gcd(currentGcd, nums[j]);
                if(currentGcd == 1){
                    minLength = Math.min(minLength, j - i + 1);
                    break;
                }
            }
        }
        return minLength + n - 2;
    }

    public static int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
