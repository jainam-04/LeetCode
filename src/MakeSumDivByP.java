import java.util.HashMap;
import java.util.Map;

public class MakeSumDivByP {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int p = 3;
        int result = minSubArray(nums, p);
        System.out.println(result);
    }

    public static int minSubArray(int[] nums, int p){
        long total = 0;
        for(int num : nums){
            total += num;
        }
        long target = total % p;
        if(target == 0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        long prefix = 0;
        int result = nums.length;
        for(int i = 0; i < nums.length; i++){
            prefix = (prefix + nums[i]) % p;
            int need = (int) ((prefix - target + p) % p);
            if(map.containsKey(need)){
                result = Math.min(result, i - map.get(need));
            }
            map.put((int) prefix, i);
        }
        return result == nums.length ? -1 : result;
    }
}
