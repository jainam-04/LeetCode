import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {
    public static void main(String[] args) {
        int[] happiness = {1, 2, 3};
        int k = 2;
        long result = maximumHappinessSum(happiness, k);
        System.out.println(result);
    }

    public static long maximumHappinessSum(int[] happiness, int k){
        Arrays.sort(happiness);
        int count = 0;
        long result = 0;
        for(int i = happiness.length - 1; i >= happiness.length - k; i--){
            if(happiness[i] + count > 0){
                result += (happiness[i] + count);
            }
            count--;
        }
        return result;
    }
}
