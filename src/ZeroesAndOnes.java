public class ZeroesAndOnes {
    public static void main(String[] args) {
        String[] strs = {"10", "0", "1"};
        int m = 1;
        int n = 1;
        int result = findMaxForm(strs, m, n);
        System.out.println(result);
    }

    public static int findMaxForm(String[] strs, int m ,int n){
        int[][] dp = new int[m + 1][n + 1];
        for(String str : strs){
            int zeroes = 0;
            int ones = 0;
            for(char ch : str.toCharArray()){
                if(ch == '0'){
                    zeroes++;
                }
                else{
                    ones++;
                }
            }
            for(int i = m; i >= zeroes; i--){
                for(int j = n; j >= ones; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroes][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
