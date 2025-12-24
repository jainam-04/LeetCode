import java.util.Arrays;

public class AppleRedistributionIntoBoxes {
    public static void main(String[] args) {
        int[] apple = {1, 3, 2};
        int[] capacity = {4, 3, 1, 5, 2};
        int result = minimumBoxes(apple, capacity);
        System.out.println(result);
    }

    public static int minimumBoxes(int[] apple, int[] capacity){
        int sum = Arrays.stream(apple).sum();
        int[] fq = new int[51];
        int high = 0;
        int low = 51;
        for(int cap : capacity){
            fq[cap]++;
            high = Math.max(cap, high);
            low = Math.min(cap, low);
        }
        int result = 0;
        for(int i = high; i >= low && sum > 0; i--){
            if(fq[i]-- > 0){
                sum -= i;
                result++;
            }
        }
        return result;
    }
}
