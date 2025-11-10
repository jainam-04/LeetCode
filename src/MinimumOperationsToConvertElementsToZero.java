import java.util.Stack;

public class MinimumOperationsToConvertElementsToZero {
    public static void main(String[] args) {
        int[] nums = {0, 2};
        int result = minOperations(nums);
        System.out.println(result);
    }

    public static int minOperations(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int num : nums){
            while(!stack.isEmpty() && stack.peek() > num){
                stack.pop();
            }
            if(num == 0){
                continue;
            }
            if(stack.isEmpty() || stack.peek() < num){
                count++;
                stack.push(num);
            }
        }
        return count;
    }
}
