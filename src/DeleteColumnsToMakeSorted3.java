import java.util.Arrays;

public class DeleteColumnsToMakeSorted3 {
    public static void main(String[] args) {
        String[] str = {"babca", "bbazb"};
        int result = minDeletionSize(str);
        System.out.println(result);
    }

    public static int minDeletionSize(String[] str){
        int n = str[0].length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(isValid(str, j, i)){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for(int val : dp){
            max = Math.max(max, val);
        }
        return n - max;
    }

    public static boolean isValid(String[] str, int j, int i){
        for(String s : str){
            if(s.charAt(j) > s.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
