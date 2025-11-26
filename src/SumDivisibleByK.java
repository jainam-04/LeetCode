import java.util.Arrays;

public class SumDivisibleByK {
    private static final int MOD = (int) 10e9 + 7;

    public static void main(String[] args) {
        int[][] grid = {
                {7, 3, 4, 9},
                {2, 3, 6, 2},
                {2, 3, 7, 0}
        };
        int k = 1;
        int result = numberOfPaths(grid, k);
        System.out.println(result);
    }

    public static int numberOfPaths(int[][] grid, int k){
        int m = grid.length;
        int n = grid[0].length;
        int[][] prev = new int[n][k];
        int[][] curr = new int[n][k];
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum = (sum + grid[0][i]) % k;
            prev[i][sum] = 1;
        }
        sum = grid[0][0] % k;
        for(int i = 1; i < m; i++){
            sum = (sum + grid[i][0]) % k;
            Arrays.fill(curr[0], 0);
            curr[0][sum] = 1;
            for(int j = 1; j < n; j++){
                Arrays.fill(curr[j], 0);
                int value = grid[i][j];
                for(int r = 0; r < k; r++){
                    int nr = (r + value) % k;
                    curr[j][nr] = (prev[j][r] + curr[j - 1][r]) % MOD;
                }
            }
            int[][] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[n - 1][0];
    }
}
