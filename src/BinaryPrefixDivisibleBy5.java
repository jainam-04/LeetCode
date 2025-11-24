import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        List<Boolean> result = prefixDivBy5(nums);
        System.out.println(result);
    }

    public static List<Boolean> prefixDivBy5(int[] nums){
        List<Boolean> result = new ArrayList<>();
        int value = 0;
        for(int num : nums){
            value = ((value << 1) + num) % 5;
            result.add(value == 0);
        }
        return result;
    }
}
