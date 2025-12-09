public class CountSpecialTriplets {
    final static int mod = (int) 1e9 + 7;
    final static int M = (int) 1e5 + 1;

    public static void main(String[] args) {
        int[] nums = {8, 4, 2, 8, 4};
        int result = specialTriplets(nums);
        System.out.println(result);
    }

    public static int specialTriplets(int[] nums){
        final int n = nums.length;
        int[] freq = new int[M];
        int[] prev = new int[M];
        for(int num : nums){
            freq[num]++;
        }
        long count = 0;
        prev[nums[0]]++;
        for(int i = 1; i < n - 1; i++){
            final int x = nums[i];
            final int x2 = x << 1;
            if(x2 < M){
                count += (long) prev[x2] * (freq[x2] - prev[x2] - (x == 0 ? 1 : 0));
            }
            prev[x]++;
        }
        return (int) count % mod;
    }
}
